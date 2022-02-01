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

public class aaqj
  extends RecyclerView.ViewHolder
{
  private alno jdField_a_of_type_Alno;
  private alpy jdField_a_of_type_Alpy;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private DragTextView jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView;
  private HashMap<String, Bitmap> jdField_a_of_type_JavaUtilHashMap;
  public tua a;
  private boolean jdField_a_of_type_Boolean;
  
  public aaqj(View paramView, alno paramalno, HashMap<String, Bitmap> paramHashMap, DragFrameLayout paramDragFrameLayout)
  {
    super(paramView);
    this.jdField_a_of_type_Alno = paramalno;
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
    this.jdField_a_of_type_Alpy = paramDragFrameLayout;
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131377385));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377390));
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131377393));
  }
  
  private void a(View paramView, tua paramtua)
  {
    if (TextUtils.equals(paramtua.jdField_a_of_type_JavaLangString, ayvd.jdField_a_of_type_JavaLangString))
    {
      ayvf.a(paramView.getContext(), paramtua.jdField_a_of_type_JavaLangString, 1);
      return;
    }
    b(paramView, paramtua);
  }
  
  private boolean a(tua paramtua1, tua paramtua2)
  {
    if ((paramtua1 != null) && (paramtua2 != null)) {
      if ((!paramtua1.jdField_a_of_type_JavaLangString.equals(paramtua2.jdField_a_of_type_JavaLangString)) || (paramtua1.b != paramtua2.b) || (paramtua1.jdField_a_of_type_Int != paramtua2.jdField_a_of_type_Int) || (!paramtua1.c.equals(paramtua2.c))) {
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
  
  private void b(View paramView, tua paramtua)
  {
    Intent localIntent = new Intent(paramView.getContext(), ChatActivity.class);
    localIntent.putExtra("uintype", 1008);
    localIntent.putExtra("uin", paramtua.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("uinname", paramtua.c);
    localIntent.putExtra("start_time", System.currentTimeMillis());
    localIntent.putExtra("red_hot_count", paramtua.b);
    localIntent.putExtra("INTENT_KEY_FROM", 2);
    paramView.getContext().startActivity(localIntent);
  }
  
  @RequiresApi(api=8)
  public void a(ImageView paramImageView, String paramString)
  {
    Bitmap localBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (localBitmap == null) {
      paramImageView.setImageDrawable(this.jdField_a_of_type_Alno.a(1008, paramString));
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
  
  public void a(tua paramtua, int paramInt)
  {
    if ((paramtua == null) || (a(this.jdField_a_of_type_Tua, paramtua))) {
      return;
    }
    this.jdField_a_of_type_Tua = paramtua;
    this.itemView.setTag(this.jdField_a_of_type_Tua);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(2131377387, this.jdField_a_of_type_Tua);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(2131377385, Integer.valueOf(paramInt));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramtua.c);
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-5723992);
    }
    a(this.jdField_a_of_type_ComTencentImageURLImageView, paramtua.jdField_a_of_type_JavaLangString);
    int j = paramtua.b;
    int i = 0;
    int k = 0;
    int m = paramtua.jdField_a_of_type_Int;
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
      blkk.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, j, k, 99, null);
      String str2 = "";
      String str1 = str2;
      if (paramtua.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
      {
        str1 = str2;
        if (paramtua.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.mExJsonObject != null) {
          str1 = paramtua.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.mExJsonObject.optString("report_key_bytes_oac_msg_extend", "");
        }
      }
      this.itemView.setOnClickListener(new aaqk(this, paramtua, paramInt, str1));
      apeg.a(null, paramtua.jdField_a_of_type_JavaLangString, paramtua.jdField_a_of_type_Int, paramtua.b, paramtua.jdField_a_of_type_JavaLangCharSequence.toString(), str1);
      abbe.a(paramtua.jdField_a_of_type_JavaLangString, "auth_follow", "new_s_exp", 0, 0, new String[] { "", "", paramtua.c, paramtua.jdField_a_of_type_JavaLangCharSequence.toString() });
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
        k = 2130850404;
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0, this.itemView);
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_Alpy);
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
 * Qualified Name:     aaqj
 * JD-Core Version:    0.7.0.1
 */