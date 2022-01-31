package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.preference.Preference;

public class PersonalPreference
  extends Preference
{
  private String bVH;
  private String cMT;
  private TextView drB = null;
  Bitmap ebo = null;
  ImageView kix = null;
  private TextView nSa = null;
  int nSb = -1;
  String nSc = null;
  private View.OnClickListener nSd;
  private String username;
  
  public PersonalPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PersonalPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setLayoutResource(a.g.mm_preference);
    setWidgetLayoutResource(a.g.mm_preference_submenu);
  }
  
  public final void onBindView(View paramView)
  {
    if (this.kix == null) {
      this.kix = ((ImageView)paramView.findViewById(a.f.image_iv));
    }
    if (this.ebo != null)
    {
      this.kix.setImageBitmap(this.ebo);
      this.kix.setOnClickListener(this.nSd);
      if ((this.drB != null) && (this.bVH != null)) {
        this.drB.setText(j.a(this.mContext, this.bVH, this.drB.getTextSize()));
      }
      if (this.nSa != null) {
        if (!bk.bl(this.cMT)) {
          break label222;
        }
      }
    }
    label222:
    for (String str = this.username;; str = this.cMT)
    {
      if ((bk.bl(this.cMT)) && (ad.aaX(this.username))) {
        this.nSa.setVisibility(8);
      }
      this.nSa.setText(this.mContext.getString(a.i.app_field_username) + str);
      super.onBindView(paramView);
      return;
      if (this.nSb > 0)
      {
        this.kix.setImageResource(this.nSb);
        break;
      }
      if (this.nSc == null) {
        break;
      }
      a.b.a(this.kix, this.nSc);
      break;
    }
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(a.f.content);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, a.g.mm_preference_content_personal, localViewGroup);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.PersonalPreference
 * JD-Core Version:    0.7.0.1
 */