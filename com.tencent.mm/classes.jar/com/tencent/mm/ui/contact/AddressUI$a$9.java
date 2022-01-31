package com.tencent.mm.ui.contact;

final class AddressUI$a$9
  implements Runnable
{
  AddressUI$a$9(AddressUI.a parama) {}
  
  public final void run()
  {
    AddressUI.a.a(this.vJs).cHn();
    if (AddressUI.a.e(this.vJs) != null)
    {
      AddressUI.a.e(this.vJs).reset();
      if (AddressUI.a.e(this.vJs).getOpenIMCount() <= 0) {
        AddressUI.a.e(this.vJs).setVisibility(8);
      }
    }
    else
    {
      return;
    }
    AddressUI.a.e(this.vJs).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.contact.AddressUI.a.9
 * JD-Core Version:    0.7.0.1
 */