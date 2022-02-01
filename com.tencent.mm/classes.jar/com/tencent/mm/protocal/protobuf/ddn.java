package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ddn
  extends esc
{
  public String YNW;
  public String ZjI;
  public String ZjJ;
  public String ZjK;
  public String ZjL;
  public String oOI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82437);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(82437);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.oOI != null) {
        paramVarArgs.g(2, this.oOI);
      }
      if (this.ZjI != null) {
        paramVarArgs.g(3, this.ZjI);
      }
      if (this.YNW != null) {
        paramVarArgs.g(4, this.YNW);
      }
      if (this.ZjJ != null) {
        paramVarArgs.g(5, this.ZjJ);
      }
      if (this.ZjK != null) {
        paramVarArgs.g(6, this.ZjK);
      }
      if (this.ZjL != null) {
        paramVarArgs.g(7, this.ZjL);
      }
      AppMethodBeat.o(82437);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label696;
      }
    }
    label696:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.oOI != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.oOI);
      }
      i = paramInt;
      if (this.ZjI != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ZjI);
      }
      paramInt = i;
      if (this.YNW != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YNW);
      }
      i = paramInt;
      if (this.ZjJ != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.ZjJ);
      }
      paramInt = i;
      if (this.ZjK != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.ZjK);
      }
      i = paramInt;
      if (this.ZjL != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.ZjL);
      }
      AppMethodBeat.o(82437);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(82437);
          throw paramVarArgs;
        }
        AppMethodBeat.o(82437);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ddn localddn = (ddn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82437);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kd localkd = new kd();
            if ((localObject != null) && (localObject.length > 0)) {
              localkd.parseFrom((byte[])localObject);
            }
            localddn.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(82437);
          return 0;
        case 2: 
          localddn.oOI = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82437);
          return 0;
        case 3: 
          localddn.ZjI = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82437);
          return 0;
        case 4: 
          localddn.YNW = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82437);
          return 0;
        case 5: 
          localddn.ZjJ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82437);
          return 0;
        case 6: 
          localddn.ZjK = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82437);
          return 0;
        }
        localddn.ZjL = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(82437);
        return 0;
      }
      AppMethodBeat.o(82437);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddn
 * JD-Core Version:    0.7.0.1
 */