package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class chf
  extends esc
{
  public int aapY;
  public int aapZ;
  public int aaqa;
  public int aaqb;
  public String aaqc;
  public int aaqd;
  public int vhk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101813);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(101813);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.vhk);
      paramVarArgs.bS(3, this.aapY);
      paramVarArgs.bS(4, this.aapZ);
      paramVarArgs.bS(5, this.aaqa);
      paramVarArgs.bS(6, this.aaqb);
      if (this.aaqc != null) {
        paramVarArgs.g(7, this.aaqc);
      }
      paramVarArgs.bS(8, this.aaqd);
      AppMethodBeat.o(101813);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label656;
      }
    }
    label656:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.vhk) + i.a.a.b.b.a.cJ(3, this.aapY) + i.a.a.b.b.a.cJ(4, this.aapZ) + i.a.a.b.b.a.cJ(5, this.aaqa) + i.a.a.b.b.a.cJ(6, this.aaqb);
      paramInt = i;
      if (this.aaqc != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.aaqc);
      }
      i = i.a.a.b.b.a.cJ(8, this.aaqd);
      AppMethodBeat.o(101813);
      return paramInt + i;
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
          AppMethodBeat.o(101813);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101813);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        chf localchf = (chf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101813);
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
            localchf.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(101813);
          return 0;
        case 2: 
          localchf.vhk = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(101813);
          return 0;
        case 3: 
          localchf.aapY = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(101813);
          return 0;
        case 4: 
          localchf.aapZ = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(101813);
          return 0;
        case 5: 
          localchf.aaqa = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(101813);
          return 0;
        case 6: 
          localchf.aaqb = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(101813);
          return 0;
        case 7: 
          localchf.aaqc = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(101813);
          return 0;
        }
        localchf.aaqd = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(101813);
        return 0;
      }
      AppMethodBeat.o(101813);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chf
 * JD-Core Version:    0.7.0.1
 */