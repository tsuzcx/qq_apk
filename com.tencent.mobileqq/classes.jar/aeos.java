import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.werewolves.WerewolvesHandler;
import java.util.List;

public class aeos
  extends BaseAdapter
{
  private aeos(GameRoomInviteActivity paramGameRoomInviteActivity) {}
  
  public int getCount()
  {
    if (this.a.jdField_a_of_type_JavaUtilList == null) {}
    for (int i = 0;; i = this.a.jdField_a_of_type_JavaUtilList.size()) {
      return Math.min(i, this.a.jdField_a_of_type_Int);
    }
  }
  
  public Object getItem(int paramInt)
  {
    if (this.a.jdField_a_of_type_JavaUtilList != null) {
      return (aeor)this.a.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    String str;
    FaceDrawable localFaceDrawable;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a).inflate(2130969119, paramViewGroup, false);
      paramViewGroup = new aeou(this.a, null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131365262));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365265));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)paramView.findViewById(2131365263));
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131365264);
      paramView.setTag(paramViewGroup);
      WerewolvesHandler localWerewolvesHandler = (WerewolvesHandler)this.a.app.a(107);
      aeor localaeor = (aeor)this.a.jdField_a_of_type_JavaUtilList.get(paramInt);
      str = localaeor.jdField_a_of_type_JavaLangString;
      if ((!((FriendsManager)this.a.app.getManager(50)).b(((aeor)this.a.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaLangString)) && (!this.a.app.getCurrentAccountUin().equals(str))) {
        break label314;
      }
      localFaceDrawable = FaceDrawable.a(this.a.app, 1, str);
      label201:
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localFaceDrawable);
      localWerewolvesHandler.a(paramViewGroup.jdField_a_of_type_AndroidWidgetTextView, str, "%s");
      if (!localaeor.jdField_a_of_type_Boolean) {
        break label335;
      }
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
      label239:
      if ((!this.a.jdField_a_of_type_Boolean) || (localaeor.jdField_a_of_type_JavaLangString.equals(this.a.app.getCurrentAccountUin()))) {
        break label346;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new aeot(this, paramInt, localWerewolvesHandler));
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_Int = 1;
      return paramView;
      paramViewGroup = (aeou)paramView.getTag();
      break;
      label314:
      localFaceDrawable = FaceDrawable.b(this.a.app, 200, str, 3);
      break label201;
      label335:
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(4);
      break label239;
      label346:
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeos
 * JD-Core Version:    0.7.0.1
 */