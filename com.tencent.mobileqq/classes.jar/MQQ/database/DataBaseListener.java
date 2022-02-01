package mqq.database;

public abstract interface DataBaseListener
{
  public abstract void onCreate(EncryptedDatabase paramEncryptedDatabase);
  
  public abstract void onOpen(EncryptedDatabase paramEncryptedDatabase);
  
  public abstract void onUpgrade(EncryptedDatabase paramEncryptedDatabase, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mqq.database.DataBaseListener
 * JD-Core Version:    0.7.0.1
 */