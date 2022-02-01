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
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.q;
import com.tencent.mm.model.u;
import com.tencent.mm.n.b;
import com.tencent.mm.openim.room.a.a;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SnsChatRoomMemberUI
  extends MMActivity
{
  private static int fvM = 5;
  private List<a> dqB;
  private w fql;
  private String fss;
  private String ftH;
  private int ftI;
  private String ftJ;
  private boolean ftK;
  private com.tencent.mm.plugin.messenger.foundation.a.k fvU;
  private String mTitle;
  private GridView xwj;
  private b xwk;
  
  public SnsChatRoomMemberUI()
  {
    AppMethodBeat.i(98527);
    this.xwj = null;
    this.xwk = null;
    this.dqB = new ArrayList();
    AppMethodBeat.o(98527);
  }
  
  private static int bS(Context paramContext)
  {
    AppMethodBeat.i(98528);
    int i = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getWidth();
    int j = (int)(paramContext.getResources().getDimension(2131165500) * 2.0F + paramContext.getResources().getDimension(2131165508));
    i = (int)((i - paramContext.getResources().getDimension(2131165489) * 1.0F) / j);
    ad.i("MicroMsg.SnsChatRoomMemberUI", "[getWrapColNum] :%s", new Object[] { Integer.valueOf(i) });
    fvM = i;
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
    this.xwj.setNumColumns(bS(this));
    AppMethodBeat.o(98530);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98529);
    super.onCreate(paramBundle);
    this.fvU = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class));
    this.fss = getIntent().getStringExtra("RoomInfo_Id");
    this.ftH = getIntent().getStringExtra("room_name");
    this.mTitle = getIntent().getStringExtra("Add_address_titile");
    this.ftI = getIntent().getIntExtra("room_member_count", 0);
    this.fql = ((c)g.ab(c.class)).apV().tH(this.fss);
    if (this.fql != null)
    {
      this.ftJ = this.fql.field_roomowner;
      this.ftK = u.aqG().equals(this.ftJ);
    }
    this.xwj = ((GridView)findViewById(2131304951));
    this.xwj.setNumColumns(bS(this));
    this.xwj.setColumnWidth(getResources().getDimensionPixelSize(2131165489));
    this.xwj.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(98521);
        if (SnsChatRoomMemberUI.a(SnsChatRoomMemberUI.this).Nq(paramAnonymousInt).type == 1)
        {
          af localaf = SnsChatRoomMemberUI.a(SnsChatRoomMemberUI.this).Nq(paramAnonymousInt).contact;
          if (localaf == null)
          {
            ad.e("MicroMsg.SnsChatRoomMemberUI", "cont is null");
            AppMethodBeat.o(98521);
            return;
          }
          String str1 = localaf.field_username;
          String str2 = localaf.field_nickname;
          paramAnonymousView = SnsChatRoomMemberUI.c(SnsChatRoomMemberUI.b(SnsChatRoomMemberUI.this), str1);
          paramAnonymousAdapterView = paramAnonymousView;
          if (bt.isNullOrNil(paramAnonymousView)) {
            paramAnonymousAdapterView = localaf.ZX();
          }
          SnsChatRoomMemberUI.a(SnsChatRoomMemberUI.this, str1, paramAnonymousAdapterView, str2);
        }
        AppMethodBeat.o(98521);
      }
    });
    this.xwk = new b(this, this.fql, this.fss, this.ftJ);
    this.xwj.setAdapter(this.xwk);
    paramBundle = q.rW(this.fss);
    if (paramBundle != null)
    {
      this.dqB.clear();
      int i = 0;
      if (i < paramBundle.size())
      {
        af localaf = this.fvU.apM().aHY((String)paramBundle.get(i));
        if ((localaf != null) && (b.ls(localaf.field_type)) && (!u.se(localaf.field_username)))
        {
          if (!this.fql.ty(localaf.field_username)) {
            break label353;
          }
          this.dqB.add(new a(localaf, 3));
        }
        for (;;)
        {
          i += 1;
          break;
          label353:
          if (this.fql.aHz(localaf.field_username)) {
            this.dqB.add(new a(localaf, 2));
          } else {
            this.dqB.add(new a(localaf, 1));
          }
        }
      }
      Collections.sort(this.dqB, new Comparator() {});
      this.xwk.notifyDataSetChanged();
    }
    setMMTitle(this.mTitle + "(" + this.dqB.size() + ")");
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
    af contact;
    int order = 0;
    int type = 1;
    
    public a(af paramaf, int paramInt)
    {
      this.contact = paramaf;
      this.order = paramInt;
    }
  }
  
  final class b
    extends BaseAdapter
  {
    private w fql;
    private List<String> fvP;
    private boolean fvR = false;
    private String fvS = null;
    private Context mContext;
    private String roomId;
    
    public b(w paramw, String paramString, List<String> paramList)
    {
      this.fql = paramString;
      this.roomId = paramList;
      this.fvP = null;
      Object localObject;
      this.fvS = localObject;
      this.mContext = paramw;
    }
    
    public final SnsChatRoomMemberUI.a Nq(int paramInt)
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
        localc.frr = ((ImageView)localView.findViewById(2131304481));
        localc.fsI = ((TextView)localView.findViewById(2131304483));
        paramView = (WindowManager)this.mContext.getSystemService("window");
        localc.fsI.setMaxWidth(paramView.getDefaultDisplay().getWidth() * 2 / 3);
        localc.fvW = ((TextView)localView.findViewById(2131304484));
        localView.setTag(localc);
        if (localc.fvW != null) {
          localc.fvW.setVisibility(8);
        }
        paramView = (SnsChatRoomMemberUI.a)SnsChatRoomMemberUI.c(SnsChatRoomMemberUI.this).get(paramInt);
        if ((paramView != null) && (paramView.type == 1))
        {
          af localaf = paramView.contact;
          a.b.c(localc.frr, localaf.field_username);
          str = SnsChatRoomMemberUI.c(this.fql, localaf.field_username);
          if (bt.isNullOrNil(localaf.field_conRemark)) {
            break label376;
          }
          paramViewGroup = localaf.field_conRemark;
          label214:
          paramView = paramViewGroup;
          if (bt.isNullOrNil(paramViewGroup)) {
            paramView = localaf.ZW();
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
          localc.fsI.setVisibility(0);
          localc.fsI.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.mContext, paramViewGroup, localc.fsI.getTextSize()));
          if (localc.fvW != null)
          {
            paramView = a.G(localaf);
            if (!TextUtils.isEmpty(paramView)) {
              break label382;
            }
            localc.fvW.setVisibility(8);
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
        localc.fvW.setVisibility(0);
        localc.fvW.setText(paramView);
      }
    }
  }
  
  static final class c
  {
    public ImageView frr;
    public TextView fsI;
    public TextView fvW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsChatRoomMemberUI
 * JD-Core Version:    0.7.0.1
 */