import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.subscribe.widget.relativevideo.ServiceFolderFollowPBHeadView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONObject;

public class aamh
  extends RecyclerView.ViewHolder
{
  private alby jdField_a_of_type_Alby;
  private aleg jdField_a_of_type_Aleg;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private DragTextView jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView;
  private HashMap<String, Bitmap> jdField_a_of_type_JavaUtilHashMap;
  public tty a;
  private boolean jdField_a_of_type_Boolean;
  
  public aamh(View paramView, alby paramalby, HashMap<String, Bitmap> paramHashMap, DragFrameLayout paramDragFrameLayout)
  {
    super(paramView);
    this.jdField_a_of_type_Alby = paramalby;
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
    this.jdField_a_of_type_Aleg = paramDragFrameLayout;
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131377245));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377250));
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131377253));
  }
  
  private void a(View paramView, tty paramtty)
  {
    if (TextUtils.equals(paramtty.jdField_a_of_type_JavaLangString, ayck.jdField_a_of_type_JavaLangString))
    {
      aycm.a(paramView.getContext(), paramtty.jdField_a_of_type_JavaLangString, 1);
      return;
    }
    b(paramView, paramtty);
  }
  
  private boolean a(tty paramtty1, tty paramtty2)
  {
    if ((paramtty1 != null) && (paramtty2 != null)) {
      if ((!paramtty1.jdField_a_of_type_JavaLangString.equals(paramtty2.jdField_a_of_type_JavaLangString)) || (paramtty1.b != paramtty2.b) || (paramtty1.jdField_a_of_type_Int != paramtty2.jdField_a_of_type_Int) || (!paramtty1.c.equals(paramtty2.c))) {
        break label88;
      }
    }
    label88:
    for (boolean bool = true;; bool = false)
    {
      QLog.d(ServiceFolderFollowPBHeadView.a(), 4, "isSameServiceData:" + bool);
      return false;
    }
  }
  
  private void b(View paramView, tty paramtty)
  {
    Intent localIntent = new Intent(paramView.getContext(), ChatActivity.class);
    localIntent.putExtra("uintype", 1008);
    localIntent.putExtra("uin", paramtty.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("uinname", paramtty.c);
    localIntent.putExtra("start_time", System.currentTimeMillis());
    localIntent.putExtra("red_hot_count", paramtty.b);
    localIntent.putExtra("INTENT_KEY_FROM", 2);
    paramView.getContext().startActivity(localIntent);
  }
  
  @RequiresApi(api=8)
  public void a(ImageView paramImageView, String paramString)
  {
    Bitmap localBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (localBitmap == null) {
      paramImageView.setImageDrawable(this.jdField_a_of_type_Alby.a(1008, paramString));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Boolean) {
        paramImageView.setColorFilter(1711276032);
      }
      return;
      paramImageView.setImageBitmap(localBitmap);
    }
  }
  
  public void a(tty paramtty, int paramInt)
  {
    if ((paramtty == null) || (a(this.jdField_a_of_type_Tty, paramtty))) {
      return;
    }
    this.jdField_a_of_type_Tty = paramtty;
    this.itemView.setTag(this.jdField_a_of_type_Tty);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(2131377247, this.jdField_a_of_type_Tty);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(2131377245, Integer.valueOf(paramInt));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramtty.c);
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-5723992);
    }
    a(this.jdField_a_of_type_ComTencentImageURLImageView, paramtty.jdField_a_of_type_JavaLangString);
    int j = paramtty.b;
    int i = 0;
    int k = 0;
    int m = paramtty.jdField_a_of_type_Int;
    if (j > 0) {
      if (m == 0)
      {
        i = 0;
        k = 0;
        j = 0;
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, this.itemView);
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(null);
      }
    }
    for (;;)
    {
      bkjh.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, j, k, 99, null);
      String str2 = "";
      String str1 = str2;
      if (paramtty.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
      {
        str1 = str2;
        if (paramtty.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.mExJsonObject != null) {
          str1 = paramtty.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.mExJsonObject.optString("report_key_bytes_oac_msg_extend", "");
        }
      }
      this.itemView.setOnClickListener(new aami(this, paramtty, paramInt, str1));
      aoqq.a(null, paramtty.jdField_a_of_type_JavaLangString, paramtty.jdField_a_of_type_Int, paramtty.b, paramtty.jdField_a_of_type_JavaLangCharSequence.toString(), str1);
      aaxb.a(paramtty.jdField_a_of_type_JavaLangString, "auth_follow", "new_s_exp", 0, 0, new String[] { "", "", paramtty.c, paramtty.jdField_a_of_type_JavaLangCharSequence.toString() });
      return;
      if (m == 2)
      {
        i = 1;
        k = 0;
        j = 0;
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, this.itemView);
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(null);
      }
      else
      {
        i = 3;
        k = 2130850392;
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0, this.itemView);
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_Aleg);
        continue;
        j = 0;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aamh
 * JD-Core Version:    0.7.0.1
 */