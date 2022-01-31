import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.data.IPSiteModel.Book;

public final class abtv
  implements Parcelable.Creator
{
  public IPSiteModel.Book a(Parcel paramParcel)
  {
    IPSiteModel.Book localBook = new IPSiteModel.Book();
    localBook.cover = paramParcel.readString();
    localBook.desc = paramParcel.readString();
    localBook.id = paramParcel.readString();
    localBook.jumpUrl = paramParcel.readString();
    localBook.name = paramParcel.readString();
    localBook.recommDesc = paramParcel.readString();
    localBook.authorName = paramParcel.readString();
    return localBook;
  }
  
  public IPSiteModel.Book[] a(int paramInt)
  {
    return new IPSiteModel.Book[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abtv
 * JD-Core Version:    0.7.0.1
 */