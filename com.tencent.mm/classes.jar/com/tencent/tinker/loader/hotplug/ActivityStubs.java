package com.tencent.tinker.loader.hotplug;

final class ActivityStubs
{
  static final String SINGLEINSTANCE_STUB_CLASSNAME_FORMAT = STUB_PACKAGE_NAME + "." + ActivityStubs.class.getSimpleName() + "$SIStub_%02X";
  static final int SINGLEINSTANCE_STUB_COUNT = 10;
  static final int SINGLEINSTANCE_TRSNAPARENT_STUB_COUNT = 3;
  static final String SINGLETASK_STUB_CLASSNAME_FORMAT;
  static final int SINGLETASK_STUB_COUNT = 10;
  static final int SINGLETASK_TRSNAPARENT_STUB_COUNT = 3;
  static final String SINGLETOP_STUB_CLASSNAME_FORMAT;
  static final int SINGLETOP_STUB_COUNT = 10;
  static final int SINGLETOP_TRSNAPARENT_STUB_COUNT = 3;
  static final int STANDARD_STUB_COUNT = 10;
  static final int STANDARD_TRSNAPARENT_STUB_COUNT = 3;
  static final String STARDARD_STUB_CLASSNAME_FORMAT;
  static final String STUB_PACKAGE_NAME = ActivityStubs.class.getPackage().getName();
  static final String TRANSPARENT_STUB_FORMAT_SUFFIX = "_T";
  
  static
  {
    STARDARD_STUB_CLASSNAME_FORMAT = STUB_PACKAGE_NAME + "." + ActivityStubs.class.getSimpleName() + "$STDStub_%02X";
    SINGLETOP_STUB_CLASSNAME_FORMAT = STUB_PACKAGE_NAME + "." + ActivityStubs.class.getSimpleName() + "$SGTStub_%02X";
    SINGLETASK_STUB_CLASSNAME_FORMAT = STUB_PACKAGE_NAME + "." + ActivityStubs.class.getSimpleName() + "$SGTKStub_%02X";
  }
  
  private ActivityStubs()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tinker.loader.hotplug.ActivityStubs
 * JD-Core Version:    0.7.0.1
 */