package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.al;
import com.tencent.mm.model.r;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SnsChatRoomMemberUI
  extends MMActivity
{
  private static int fUM = 5;
  private GridView ArG;
  private b ArH;
  private List<a> dBf;
  private ac fNS;
  private String fRo;
  private String fSH;
  private int fSI;
  private String fSJ;
  private boolean fSK;
  private l fUW;
  private String mTitle;
  
  public SnsChatRoomMemberUI()
  {
    AppMethodBeat.i(98527);
    this.ArG = null;
    this.ArH = null;
    this.dBf = new ArrayList();
    AppMethodBeat.o(98527);
  }
  
  private static int bV(Context paramContext)
  {
    AppMethodBeat.i(98528);
    int i = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getWidth();
    int j = (int)(paramContext.getResources().getDimension(2131165500) * 2.0F + paramContext.getResources().getDimension(2131165508));
    i = (int)((i - paramContext.getResources().getDimension(2131165489) * 1.0F) / j);
    ae.i("MicroMsg.SnsChatRoomMemberUI", "[getWrapColNum] :%s", new Object[] { Integer.valueOf(i) });
    fUM = i;
    AppMethodBeat.o(98528);
    return i;
  }
  
  public int getLayoutId()
  {
    return 2131495533;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(98530);
    super.onConfigurationChanged(paramConfiguration);
    this.ArG.setNumColumns(bV(this));
    AppMethodBeat.o(98530);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98529);
    super.onCreate(paramBundle);
    this.fUW = ((l)g.ab(l.class));
    this.fRo = getIntent().getStringExtra("RoomInfo_Id");
    this.fSH = getIntent().getStringExtra("room_name");
    this.mTitle = getIntent().getStringExtra("Add_address_titile");
    this.fSI = getIntent().getIntExtra("room_member_count", 0);
    this.fNS = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bx(this.fRo);
    if (this.fNS != null)
    {
      this.fSJ = this.fNS.field_roomowner;
      this.fSK = v.aAC().equals(this.fSJ);
    }
    this.ArG = ((GridView)findViewById(2131304951));
    this.ArG.setNumColumns(bV(this));
    this.ArG.setColumnWidth(getResources().getDimensionPixelSize(2131165489));
    this.ArG.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(98521);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousAdapterView);
        ((b)localObject).bd(paramAnonymousView);
        ((b)localObject).mu(paramAnonymousInt);
        ((b)localObject).rl(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsChatRoomMemberUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((b)localObject).ahF());
        if (SnsChatRoomMemberUI.a(SnsChatRoomMemberUI.this).RK(paramAnonymousInt).type == 1)
        {
          an localan = SnsChatRoomMemberUI.a(SnsChatRoomMemberUI.this).RK(paramAnonymousInt).contact;
          if (localan == null)
          {
            ae.e("MicroMsg.SnsChatRoomMemberUI", "cont is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsChatRoomMemberUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(98521);
            return;
          }
          localObject = localan.field_username;
          String str = localan.field_nickname;
          paramAnonymousView = SnsChatRoomMemberUI.c(SnsChatRoomMemberUI.b(SnsChatRoomMemberUI.this), (String)localObject);
          paramAnonymousAdapterView = paramAnonymousView;
          if (bu.isNullOrNil(paramAnonymousView)) {
            paramAnonymousAdapterView = localan.adG();
          }
          SnsChatRoomMemberUI.a(SnsChatRoomMemberUI.this, (String)localObject, paramAnonymousAdapterView, str);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsChatRoomMemberUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(98521);
      }
    });
    this.ArH = new b(this, this.fNS, this.fRo, this.fSJ);
    this.ArG.setAdapter(this.ArH);
    paramBundle = r.zA(this.fRo);
    if (paramBundle != null)
    {
      this.dBf.clear();
      int i = 0;
      if (i < paramBundle.size())
      {
        an localan = this.fUW.azF().BH((String)paramBundle.get(i));
        if ((localan != null) && (com.tencent.mm.contact.c.lO(localan.field_type)) && (!v.zK(localan.field_username)))
        {
          if (!this.fNS.Bj(localan.field_username)) {
            break label353;
          }
          this.dBf.add(new a(localan, 3));
        }
        for (;;)
        {
          i += 1;
          break;
          label353:
          if (this.fNS.aUg(localan.field_username)) {
            this.dBf.add(new a(localan, 2));
          } else {
            this.dBf.add(new a(localan, 1));
          }
        }
      }
      Collections.sort(this.dBf, new Comparator() {});
      this.ArH.notifyDataSetChanged();
    }
    setMMTitle(this.mTitle + "(" + this.dBf.size() + ")");
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(98522);
        SnsChatRoomMemberUI.this.setResult(0);
        SnsChatRoomMemberUI.this.finish();
        AppMethodBeat.o(98522);
        return true;
      }
    });
    AppMethodBeat.o(98529);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
  {
    an contact;
    int order = 0;
    int type = 1;
    
    public a(an paraman, int paramInt)
    {
      this.contact = paraman;
      this.order = paramInt;
    }
  }
  
  final class b
    extends BaseAdapter
  {
    private ac fNS;
    private List<String> fUR;
    private boolean fUT = false;
    private String fUU = null;
    private Context mContext;
    private String roomId;
    
    public b(ac paramac, String paramString, List<String> paramList)
    {
      this.fNS = paramString;
      this.roomId = paramList;
      this.fUR = null;
      Object localObject;
      this.fUU = localObject;
      this.mContext = paramac;
    }
    
    public final SnsChatRoomMemberUI.a RK(int paramInt)
    {
      AppMethodBeat.i(98523);
      SnsChatRoomMemberUI.a locala = (SnsChatRoomMemberUI.a)SnsChatRoomMemberUI.c(SnsChatRoomMemberUI.this).get(paramInt);
      AppMethodBeat.o(98523);
      return locala;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(98525);
      int i = SnsChatRoomMemberUI.c(SnsChatRoomMemberUI.this).size();
      AppMethodBeat.o(98525);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(98524);
      View localView;
      SnsChatRoomMemberUI.c localc;
      String str;
      if (paramView == null)
      {
        localView = View.inflate(this.mContext, 2131495532, null);
        localc = new SnsChatRoomMemberUI.c((byte)0);
        localc.fQl = ((ImageView)localView.findViewById(2131304481));
        localc.fRI = ((TextView)localView.findViewById(2131304483));
        paramView = (WindowManager)this.mContext.getSystemService("window");
        localc.fRI.setMaxWidth(paramView.getDefaultDisplay().getWidth() * 2 / 3);
        localc.fUZ = ((TextView)localView.findViewById(2131304484));
        localView.setTag(localc);
        if (localc.fUZ != null) {
          localc.fUZ.setVisibility(8);
        }
        paramView = (SnsChatRoomMemberUI.a)SnsChatRoomMemberUI.c(SnsChatRoomMemberUI.this).get(paramInt);
        if ((paramView != null) && (paramView.type == 1))
        {
          an localan = paramView.contact;
          a.b.c(localc.fQl, localan.field_username);
          str = SnsChatRoomMemberUI.c(this.fNS, localan.field_username);
          if (bu.isNullOrNil(localan.field_conRemark)) {
            break label376;
          }
          paramViewGroup = localan.field_conRemark;
          label214:
          paramView = paramViewGroup;
          if (bu.isNullOrNil(paramViewGroup)) {
            paramView = localan.adF();
          }
          paramViewGroup = paramView;
          if (str != null)
          {
            paramViewGroup = paramView;
            if (!str.equals(""))
            {
              paramViewGroup = paramView;
              if (!paramView.equals(str)) {
                paramViewGroup = str + "( " + paramView + " )";
              }
            }
          }
          localc.fRI.setVisibility(0);
          localc.fRI.setText(k.b(this.mContext, paramViewGroup, localc.fRI.getTextSize()));
          if (localc.fUZ != null)
          {
            paramView = com.tencent.mm.openim.room.a.a.O(localan);
            if (!TextUtils.isEmpty(paramView)) {
              break label382;
            }
            localc.fUZ.setVisibility(8);
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(98524);
        return localView;
        localc = (SnsChatRoomMemberUI.c)paramView.getTag();
        localView = paramView;
        break;
        label376:
        paramViewGroup = str;
        break label214;
        label382:
        localc.fUZ.setVisibility(0);
        localc.fUZ.setText(paramView);
      }
    }
  }
  
  static final class c
  {
    public ImageView fQl;
    public TextView fRI;
    public TextView fUZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsChatRoomMemberUI
 * JD-Core Version:    0.7.0.1
 */