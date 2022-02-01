package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fsy
  extends esc
{
  public String aaVP;
  public int aapY;
  public int aapZ;
  public int aaqa;
  public int aaqb;
  public String aaqc;
  public int aaqd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101834);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(101834);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.aaVP != null) {
        paramVarArgs.g(2, this.aaVP);
      }
      if (this.aaqc != null) {
        paramVarArgs.g(3, this.aaqc);
      }
      paramVarArgs.bS(4, this.aaqb);
      paramVarArgs.bS(5, this.aapY);
      paramVarArgs.bS(6, this.aapZ);
      paramVarArgs.bS(7, this.aaqa);
      paramVarArgs.bS(8, this.aaqd);
      AppMethodBeat.o(101834);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label688;
      }
    }
    label688:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aaVP != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aaVP);
      }
      i = paramInt;
      if (this.aaqc != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aaqc);
      }
      paramInt = i.a.a.b.b.a.cJ(4, this.aaqb);
      int j = i.a.a.b.b.a.cJ(5, this.aapY);
      int k = i.a.a.b.b.a.cJ(6, this.aapZ);
      int m = i.a.a.b.b.a.cJ(7, this.aaqa);
      int n = i.a.a.b.b.a.cJ(8, this.aaqd);
      AppMethodBeat.o(101834);
      return i + paramInt + j + k + m + n;
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
          AppMethodBeat.o(101834);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101834);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fsy localfsy = (fsy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101834);
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
            localfsy.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(101834);
          return 0;
        case 2: 
          localfsy.aaVP = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(101834);
          return 0;
        case 3: 
          localfsy.aaqc = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(101834);
          return 0;
        case 4: 
          localfsy.aaqb = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(101834);
          return 0;
        case 5: 
          localfsy.aapY = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(101834);
          return 0;
        case 6: 
          localfsy.aapZ = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(101834);
          return 0;
        case 7: 
          localfsy.aaqa = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(101834);
          return 0;
        }
        localfsy.aaqd = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(101834);
        return 0;
      }
      AppMethodBeat.o(101834);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fsy
 * JD-Core Version:    0.7.0.1
 */