package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class SchemaInfo
  extends com.tencent.mm.bx.a
{
  public String android_app_public_key;
  public String android_appstore_scheme;
  public String android_package;
  public String android_universal_link;
  public String appstore_link;
  public String scheme;
  public String universal_link;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258531);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.universal_link != null) {
        paramVarArgs.g(1, this.universal_link);
      }
      if (this.scheme != null) {
        paramVarArgs.g(2, this.scheme);
      }
      if (this.appstore_link != null) {
        paramVarArgs.g(3, this.appstore_link);
      }
      if (this.android_universal_link != null) {
        paramVarArgs.g(4, this.android_universal_link);
      }
      if (this.android_appstore_scheme != null) {
        paramVarArgs.g(5, this.android_appstore_scheme);
      }
      if (this.android_package != null) {
        paramVarArgs.g(6, this.android_package);
      }
      if (this.android_app_public_key != null) {
        paramVarArgs.g(7, this.android_app_public_key);
      }
      AppMethodBeat.o(258531);
      return 0;
    }
    if (paramInt == 1) {
      if (this.universal_link == null) {
        break label574;
      }
    }
    label574:
    for (int i = i.a.a.b.b.a.h(1, this.universal_link) + 0;; i = 0)
    {
      paramInt = i;
      if (this.scheme != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.scheme);
      }
      i = paramInt;
      if (this.appstore_link != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.appstore_link);
      }
      paramInt = i;
      if (this.android_universal_link != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.android_universal_link);
      }
      i = paramInt;
      if (this.android_appstore_scheme != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.android_appstore_scheme);
      }
      paramInt = i;
      if (this.android_package != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.android_package);
      }
      i = paramInt;
      if (this.android_app_public_key != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.android_app_public_key);
      }
      AppMethodBeat.o(258531);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258531);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        SchemaInfo localSchemaInfo = (SchemaInfo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258531);
          return -1;
        case 1: 
          localSchemaInfo.universal_link = locala.ajGk.readString();
          AppMethodBeat.o(258531);
          return 0;
        case 2: 
          localSchemaInfo.scheme = locala.ajGk.readString();
          AppMethodBeat.o(258531);
          return 0;
        case 3: 
          localSchemaInfo.appstore_link = locala.ajGk.readString();
          AppMethodBeat.o(258531);
          return 0;
        case 4: 
          localSchemaInfo.android_universal_link = locala.ajGk.readString();
          AppMethodBeat.o(258531);
          return 0;
        case 5: 
          localSchemaInfo.android_appstore_scheme = locala.ajGk.readString();
          AppMethodBeat.o(258531);
          return 0;
        case 6: 
          localSchemaInfo.android_package = locala.ajGk.readString();
          AppMethodBeat.o(258531);
          return 0;
        }
        localSchemaInfo.android_app_public_key = locala.ajGk.readString();
        AppMethodBeat.o(258531);
        return 0;
      }
      AppMethodBeat.o(258531);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.SchemaInfo
 * JD-Core Version:    0.7.0.1
 */