package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eyy
  extends com.tencent.mm.bx.a
{
  public LinkedList<eyx> abAd;
  public String abzW;
  public String hJW;
  public String zIC;
  
  public eyy()
  {
    AppMethodBeat.i(122532);
    this.abAd = new LinkedList();
    AppMethodBeat.o(122532);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122533);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.zIC != null) {
        paramVarArgs.g(1, this.zIC);
      }
      if (this.abzW != null) {
        paramVarArgs.g(2, this.abzW);
      }
      if (this.hJW != null) {
        paramVarArgs.g(3, this.hJW);
      }
      paramVarArgs.e(4, 8, this.abAd);
      AppMethodBeat.o(122533);
      return 0;
    }
    if (paramInt == 1) {
      if (this.zIC == null) {
        break label452;
      }
    }
    label452:
    for (int i = i.a.a.b.b.a.h(1, this.zIC) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abzW != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abzW);
      }
      i = paramInt;
      if (this.hJW != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.hJW);
      }
      paramInt = i.a.a.a.c(4, 8, this.abAd);
      AppMethodBeat.o(122533);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abAd.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(122533);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        eyy localeyy = (eyy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122533);
          return -1;
        case 1: 
          localeyy.zIC = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(122533);
          return 0;
        case 2: 
          localeyy.abzW = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(122533);
          return 0;
        case 3: 
          localeyy.hJW = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(122533);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          eyx localeyx = new eyx();
          if ((localObject != null) && (localObject.length > 0)) {
            localeyx.parseFrom((byte[])localObject);
          }
          localeyy.abAd.add(localeyx);
          paramInt += 1;
        }
        AppMethodBeat.o(122533);
        return 0;
      }
      AppMethodBeat.o(122533);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eyy
 * JD-Core Version:    0.7.0.1
 */