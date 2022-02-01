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
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.q;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SnsChatRoomMemberUI
  extends MMActivity
{
  private static int fSG = 5;
  private GridView Aat;
  private b Aau;
  private List<a> dAa;
  private ab fLO;
  private String fPi;
  private String fQB;
  private int fQC;
  private String fQD;
  private boolean fQE;
  private l fSQ;
  private String mTitle;
  
  public SnsChatRoomMemberUI()
  {
    AppMethodBeat.i(98527);
    this.Aat = null;
    this.Aau = null;
    this.dAa = new ArrayList();
    AppMethodBeat.o(98527);
  }
  
  private static int bT(Context paramContext)
  {
    AppMethodBeat.i(98528);
    int i = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getWidth();
    int j = (int)(paramContext.getResources().getDimension(2131165500) * 2.0F + paramContext.getResources().getDimension(2131165508));
    i = (int)((i - paramContext.getResources().getDimension(2131165489) * 1.0F) / j);
    ad.i("MicroMsg.SnsChatRoomMemberUI", "[getWrapColNum] :%s", new Object[] { Integer.valueOf(i) });
    fSG = i;
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
    this.Aat.setNumColumns(bT(this));
    AppMethodBeat.o(98530);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98529);
    super.onCreate(paramBundle);
    this.fSQ = ((l)g.ab(l.class));
    this.fPi = getIntent().getStringExtra("RoomInfo_Id");
    this.fQB = getIntent().getStringExtra("room_name");
    this.mTitle = getIntent().getStringExtra("Add_address_titile");
    this.fQC = getIntent().getIntExtra("room_member_count", 0);
    this.fLO = ((c)g.ab(c.class)).azz().AN(this.fPi);
    if (this.fLO != null)
    {
      this.fQD = this.fLO.field_roomowner;
      this.fQE = u.aAm().equals(this.fQD);
    }
    this.Aat = ((GridView)findViewById(2131304951));
    this.Aat.setNumColumns(bT(this));
    this.Aat.setColumnWidth(getResources().getDimensionPixelSize(2131165489));
    this.Aat.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(98521);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).mr(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).qY(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsChatRoomMemberUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        if (SnsChatRoomMemberUI.a(SnsChatRoomMemberUI.this).Rd(paramAnonymousInt).type == 1)
        {
          am localam = SnsChatRoomMemberUI.a(SnsChatRoomMemberUI.this).Rd(paramAnonymousInt).contact;
          if (localam == null)
          {
            ad.e("MicroMsg.SnsChatRoomMemberUI", "cont is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsChatRoomMemberUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(98521);
            return;
          }
          localObject = localam.field_username;
          String str = localam.field_nickname;
          paramAnonymousView = SnsChatRoomMemberUI.c(SnsChatRoomMemberUI.b(SnsChatRoomMemberUI.this), (String)localObject);
          paramAnonymousAdapterView = paramAnonymousView;
          if (bt.isNullOrNil(paramAnonymousView)) {
            paramAnonymousAdapterView = localam.adv();
          }
          SnsChatRoomMemberUI.a(SnsChatRoomMemberUI.this, (String)localObject, paramAnonymousAdapterView, str);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsChatRoomMemberUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(98521);
      }
    });
    this.Aau = new b(this, this.fLO, this.fPi, this.fQD);
    this.Aat.setAdapter(this.Aau);
    paramBundle = q.yQ(this.fPi);
    if (paramBundle != null)
    {
      this.dAa.clear();
      int i = 0;
      if (i < paramBundle.size())
      {
        am localam = this.fSQ.azp().Bf((String)paramBundle.get(i));
        if ((localam != null) && (com.tencent.mm.o.b.lM(localam.field_type)) && (!u.za(localam.field_username)))
        {
          if (!this.fLO.Az(localam.field_username)) {
            break label353;
          }
          this.dAa.add(new a(localam, 3));
        }
        for (;;)
        {
          i += 1;
          break;
          label353:
          if (this.fLO.aSH(localam.field_username)) {
            this.dAa.add(new a(localam, 2));
          } else {
            this.dAa.add(new a(localam, 1));
          }
        }
      }
      Collections.sort(this.dAa, new Comparator() {});
      this.Aau.notifyDataSetChanged();
    }
    setMMTitle(this.mTitle + "(" + this.dAa.size() + ")");
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
    am contact;
    int order = 0;
    int type = 1;
    
    public a(am paramam, int paramInt)
    {
      this.contact = paramam;
      this.order = paramInt;
    }
  }
  
  final class b
    extends BaseAdapter
  {
    private ab fLO;
    private List<String> fSL;
    private boolean fSN = false;
    private String fSO = null;
    private Context mContext;
    private String roomId;
    
    public b(ab paramab, String paramString, List<String> paramList)
    {
      this.fLO = paramString;
      this.roomId = paramList;
      this.fSL = null;
      Object localObject;
      this.fSO = localObject;
      this.mContext = paramab;
    }
    
    public final SnsChatRoomMemberUI.a Rd(int paramInt)
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
        localc.fOf = ((ImageView)localView.findViewById(2131304481));
        localc.fPC = ((TextView)localView.findViewById(2131304483));
        paramView = (WindowManager)this.mContext.getSystemService("window");
        localc.fPC.setMaxWidth(paramView.getDefaultDisplay().getWidth() * 2 / 3);
        localc.fST = ((TextView)localView.findViewById(2131304484));
        localView.setTag(localc);
        if (localc.fST != null) {
          localc.fST.setVisibility(8);
        }
        paramView = (SnsChatRoomMemberUI.a)SnsChatRoomMemberUI.c(SnsChatRoomMemberUI.this).get(paramInt);
        if ((paramView != null) && (paramView.type == 1))
        {
          am localam = paramView.contact;
          a.b.c(localc.fOf, localam.field_username);
          str = SnsChatRoomMemberUI.c(this.fLO, localam.field_username);
          if (bt.isNullOrNil(localam.field_conRemark)) {
            break label376;
          }
          paramViewGroup = localam.field_conRemark;
          label214:
          paramView = paramViewGroup;
          if (bt.isNullOrNil(paramViewGroup)) {
            paramView = localam.adu();
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
          localc.fPC.setVisibility(0);
          localc.fPC.setText(k.b(this.mContext, paramViewGroup, localc.fPC.getTextSize()));
          if (localc.fST != null)
          {
            paramView = com.tencent.mm.openim.room.a.a.H(localam);
            if (!TextUtils.isEmpty(paramView)) {
              break label382;
            }
            localc.fST.setVisibility(8);
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
        localc.fST.setVisibility(0);
        localc.fST.setText(paramView);
      }
    }
  }
  
  static final class c
  {
    public ImageView fOf;
    public TextView fPC;
    public TextView fST;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsChatRoomMemberUI
 * JD-Core Version:    0.7.0.1
 */