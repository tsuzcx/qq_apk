package com.tencent.tinker.loader.hotplug;

final class ActivityStubs
{
  static final String alh = ActivityStubs.class.getPackage().getName();
  static final String ali = alh + "." + ActivityStubs.class.getSimpleName() + "$STDStub_%02X";
  static final String alj = alh + "." + ActivityStubs.class.getSimpleName() + "$SGTStub_%02X";
  static final String alk = alh + "." + ActivityStubs.class.getSimpleName() + "$SGTKStub_%02X";
  static final String all = alh + "." + ActivityStubs.class.getSimpleName() + "$SIStub_%02X";
  
  private ActivityStubs()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.hotplug.ActivityStubs
 * JD-Core Version:    0.7.0.1
 */