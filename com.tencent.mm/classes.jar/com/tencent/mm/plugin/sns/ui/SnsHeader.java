package com.tencent.mm.plugin.sns.ui;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.ShapeDrawable.ShaderFactory;
import android.graphics.drawable.shapes.RectShape;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.c.awe;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.storage.az;
import com.tencent.mm.vfs.e;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@SuppressLint({"UseSparseArrays"})
public class SnsHeader
  extends LinearLayout
{
  boolean bMo = false;
  Context context;
  String diG;
  private Dialog kXe;
  SnsHeader.c oYj;
  private SnsHeader.a oYk;
  private SnsHeader.b oYl;
  private boolean oYm = false;
  private Map<Integer, View> oYn = new HashMap();
  private String oYo = "";
  Bitmap oYp = null;
  private int type;
  String userName;
  
  public SnsHeader(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public SnsHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.context = paramContext;
    View localView = com.tencent.mm.ui.y.gt(paramContext).inflate(i.g.sns_header_item2, this, true);
    this.oYj = new SnsHeader.c(this);
    this.oYj.hPg = ((TextView)localView.findViewById(i.f.nickname_tv));
    this.oYj.dpY = ((ImageView)localView.findViewById(i.f.avatar_iv));
    this.oYj.oMX = ((TextView)localView.findViewById(i.f.sign_tv));
    this.oYj.oYv = ((ImageView)localView.findViewById(i.f.sns_back_ll));
    this.oYj.oYw = ((ImageView)localView.findViewById(i.f.sns_back_mask));
    this.oYj.oYx = ((LinearLayout)localView.findViewById(i.f.setting_bg));
    this.oYj.oYy = ((LinearLayout)localView.findViewById(i.f.sns_error_list));
    this.oYj.oYv.setContentDescription(paramContext.getString(i.j.sns_background_desc));
    this.oYj.oYv.setOnClickListener(new SnsHeader.1(this, paramContext));
    this.oYj.dpY.setOnClickListener(new SnsHeader.2(this, paramContext));
  }
  
  public final void bIM()
  {
    Object localObject3 = this.userName;
    if (this.type == 1) {
      localObject3 = this.diG;
    }
    Object localObject1 = af.getAccSnsPath();
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SnsHeader", "MagicAsyncTask " + (String)localObject3);
    l locall = af.bDJ().OF((String)localObject3);
    String str1 = locall.field_bgId;
    Object localObject4 = locall.field_older_bgId;
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SnsHeader", "showName " + (String)localObject3 + " get bgId : " + str1 + "  olderBgId：　" + (String)localObject4);
    localObject4 = i.MT(str1);
    String str5 = (String)localObject3 + "bg_";
    String str2 = (String)localObject3 + "tbg_";
    String str3 = an.eJ((String)localObject1, (String)localObject3);
    e.nb(str3);
    int i;
    String str4;
    if ((locall.field_local_flag & 0x1) > 0)
    {
      i = 1;
      if (i != 0)
      {
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SnsHeader", "bg is change");
        af.bDJ().OE((String)localObject3);
        if (e.bK(an.eJ((String)localObject1, (String)localObject3) + str5))
        {
          e.deleteFile(an.eJ((String)localObject1, (String)localObject3) + str2);
          e.f(an.eJ((String)localObject1, (String)localObject3), str5, str2);
        }
        locall.field_local_flag &= 0xFFFFFFFE;
        af.bDJ().c(locall);
      }
      if ((e.bK(an.eJ(af.getAccSnsPath(), str1) + (String)localObject4)) && (!e.bK(an.eJ((String)localObject1, (String)localObject3) + str5)))
      {
        e.r(an.eJ((String)localObject1, str1) + (String)localObject4, an.eJ((String)localObject1, (String)localObject3) + str5);
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SnsHeader", "nwer id Name update");
      }
      str4 = locall.field_bgUrl;
      if (str1 == null) {
        break label898;
      }
      af.bDC();
      localObject1 = str3 + str5;
      this.context.hashCode();
      localObject4 = g.a((String)localObject1, str4, str1, true, az.uBK);
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SnsHeader", "set a new bg");
      localObject1 = localObject4;
      if (localObject4 == null) {
        e.deleteFile(str3 + str5);
      }
    }
    label811:
    Object localObject2;
    label898:
    for (localObject1 = localObject4;; localObject2 = null)
    {
      localObject4 = localObject1;
      if (localObject1 == null)
      {
        localObject4 = localObject1;
        if (str1 != null)
        {
          af.bDC();
          localObject1 = str3 + str2;
          this.context.hashCode();
          localObject4 = g.a((String)localObject1, str4, str1, false, az.uBK);
        }
      }
      if (this.oYj.oYv != null)
      {
        this.oYj.oYv.setImageBitmap((Bitmap)localObject4);
        if (localObject4 == null) {
          break label811;
        }
        this.oYj.oYv.setBackgroundDrawable(null);
      }
      for (;;)
      {
        this.oYj.oYx.setVisibility(8);
        if ((localObject4 == null) && ((this.type == 1) || (this.diG.equals(localObject3)))) {
          this.oYj.oYx.setVisibility(0);
        }
        this.oYm = locall.bGt();
        if (this.oYl != null)
        {
          this.oYl.M((Bitmap)localObject4);
          if (localObject4 != null)
          {
            int j = a.fromDPToPix(this.context, 65);
            i = j;
            if (j > ((Bitmap)localObject4).getHeight()) {
              i = ((Bitmap)localObject4).getHeight();
            }
            localObject1 = new SnsHeader.3(this, com.tencent.mm.ui.ak.Y(Bitmap.createBitmap(localObject4, 0, 0, localObject4.getWidth(), i))[0]);
            localObject3 = new PaintDrawable();
            ((PaintDrawable)localObject3).setShape(new RectShape());
            ((PaintDrawable)localObject3).setShaderFactory((ShapeDrawable.ShaderFactory)localObject1);
            this.oYj.oYw.setBackground((Drawable)localObject3);
          }
        }
        return;
        i = 0;
        break;
        try
        {
          if ((this.oYp == null) || (this.oYp.isRecycled()))
          {
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsHeader", "decode bitmap by self");
            this.oYp = c.decodeStream(this.context.getAssets().open("resource/friendactivity_mycover_bg.jpg"));
          }
          localObject1 = new BitmapDrawable(this.oYp);
          this.oYj.oYv.setBackgroundDrawable((Drawable)localObject1);
        }
        catch (IOException localIOException)
        {
          com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.SnsHeader", localIOException, "", new Object[0]);
        }
      }
    }
  }
  
  public final boolean bIN()
  {
    if (this.oYj.oYy == null) {}
    LinkedList localLinkedList;
    label102:
    do
    {
      int i;
      do
      {
        return false;
        localObject = aj.bDY();
        localLinkedList = new LinkedList();
        i = 0;
        n localn1;
        boolean bool;
        for (;;)
        {
          if (i >= ((List)localObject).size()) {
            break label102;
          }
          localn1 = (n)((List)localObject).get(i);
          try
          {
            bool = ((awe)new awe().aH(localn1.field_postBuf)).tsD;
            if (!bool) {
              break;
            }
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              localLinkedList.add(localn1);
            }
          }
          i += 1;
        }
        localObject = "";
        i = 0;
        for (;;)
        {
          if (i >= localLinkedList.size()) {
            break label212;
          }
          localn1 = (n)localLinkedList.get(i);
          try
          {
            bool = ((awe)new awe().aH(localn1.field_postBuf)).tsD;
            if (!bool) {
              break;
            }
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              localObject = (String)localObject + ((n)localLinkedList.get(i)).bGE() + " ";
            }
          }
          i += 1;
        }
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsHeader", "refreshError %s %s %s", new Object[] { Integer.valueOf(localLinkedList.size()), localObject, this.oYo });
        if (!((String)localObject).equals(this.oYo)) {
          break;
        }
      } while (localLinkedList.size() <= 0);
      return true;
      this.oYo = ((String)localObject);
      this.oYj.oYy.removeAllViews();
      Object localObject = this.oYj.oYy;
      int j;
      int k;
      TextView localTextView;
      if (localLinkedList.size() > 0)
      {
        i = 0;
        ((LinearLayout)localObject).setVisibility(i);
        Collections.sort(localLinkedList, new SnsHeader.d(this));
        i = 0;
        if (i >= localLinkedList.size()) {
          continue;
        }
        j = ((n)localLinkedList.get(i)).oLk;
        k = localLinkedList.size();
        if ((!this.oYn.containsKey(Integer.valueOf(j))) || (this.oYn.get(Integer.valueOf(j)) == null)) {
          break label514;
        }
        localObject = (View)this.oYn.get(Integer.valueOf(j));
        localObject = (LinearLayout)localObject;
        ((LinearLayout)localObject).getChildAt(0).setTag(((n)localLinkedList.get(i)).bGE());
        n localn2 = (n)localLinkedList.get(i);
        localTextView = (TextView)((LinearLayout)localObject).findViewById(i.f.sns_notify_tips2);
        if (localn2.field_type != 15) {
          break label571;
        }
        localTextView.setText(i.j.sns_post_sight_error);
      }
      for (;;)
      {
        this.oYj.oYy.addView((View)localObject);
        i += 1;
        break label331;
        i = 8;
        break;
        localObject = (LinearLayout)com.tencent.mm.ui.y.gt(this.context).inflate(i.g.header_error_list, null);
        ((LinearLayout)localObject).getChildAt(0).setOnClickListener(new SnsHeader.4(this, k, i));
        this.oYn.put(Integer.valueOf(j), localObject);
        break label415;
        localTextView.setTag(Integer.valueOf(i.j.sns_post_error));
      }
    } while (localLinkedList.size() <= 0);
    label212:
    return true;
  }
  
  public void setAvatarOnClickListener(View.OnClickListener paramOnClickListener)
  {
    if ((this.oYj != null) && (this.oYj.dpY != null)) {
      this.oYj.dpY.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setBackClickListener(SnsHeader.a parama)
  {
    this.oYk = parama;
  }
  
  public void setHeadBgListener(SnsHeader.b paramb)
  {
    this.oYl = paramb;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
    if ((paramInt == 1) && (this.oYj.oMX != null)) {
      this.oYj.oMX.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsHeader
 * JD-Core Version:    0.7.0.1
 */