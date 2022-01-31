import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;

public class aagz
  extends ajto
{
  public aagz(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  protected void onCardDownload(boolean paramBoolean, Object paramObject)
  {
    Object localObject;
    if ((paramBoolean) && (paramObject != null))
    {
      if (!(paramObject instanceof Card)) {
        break label163;
      }
      localObject = (Card)paramObject;
      if ((((Card)localObject).uin != null) && (((Card)localObject).uin.equals(AddFriendVerifyActivity.a(this.a))))
      {
        paramObject = bbac.a(this.a, ((Card)localObject).shGender, ((Card)localObject).age, ((Card)localObject).strCountry, ((Card)localObject).strProvince, ((Card)localObject).strCity);
        if (this.a.a != null) {
          paramObject = bbac.a(this.a, ((Card)localObject).shGender, 0, "", "", "");
        }
        if (!TextUtils.isEmpty(paramObject))
        {
          this.a.c.setVisibility(0);
          this.a.c.setText(paramObject);
        }
      }
    }
    for (;;)
    {
      if (bduf.b(this.a.app, AddFriendVerifyActivity.a(this.a))) {
        this.a.c.setVisibility(8);
      }
      return;
      label163:
      if ((paramObject instanceof ContactCard))
      {
        localObject = (ContactCard)paramObject;
        if ((((ContactCard)localObject).mobileNo != null) && (((ContactCard)localObject).mobileNo.equals(AddFriendVerifyActivity.a(this.a))))
        {
          paramObject = bbac.a(this.a, ((ContactCard)localObject).bSex, ((ContactCard)localObject).bAge, ((ContactCard)localObject).strCountry, ((ContactCard)localObject).strProvince, ((ContactCard)localObject).strCity);
          if (this.a.a != null) {
            paramObject = bbac.a(this.a, ((ContactCard)localObject).bSex, 0, "", "", "");
          }
          if (!TextUtils.isEmpty(paramObject))
          {
            this.a.c.setVisibility(0);
            this.a.c.setText(paramObject);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aagz
 * JD-Core Version:    0.7.0.1
 */