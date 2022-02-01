package com.tencent.tinker.loader.hotplug;

final class ActivityStubs
{
  static final String aoH = ActivityStubs.class.getPackage().getName();
  static final String aoI = aoH + "." + ActivityStubs.class.getSimpleName() + "$STDStub_%02X";
  static final String aoJ = aoH + "." + ActivityStubs.class.getSimpleName() + "$SGTStub_%02X";
  static final String aoK = aoH + "." + ActivityStubs.class.getSimpleName() + "$SGTKStub_%02X";
  static final String aoL = aoH + "." + ActivityStubs.class.getSimpleName() + "$SIStub_%02X";
  
  private ActivityStubs()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.hotplug.ActivityStubs
 * JD-Core Version:    0.7.0.1
 */