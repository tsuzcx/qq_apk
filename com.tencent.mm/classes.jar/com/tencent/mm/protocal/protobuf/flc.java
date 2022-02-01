package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class flc
  extends com.tencent.mm.bx.a
{
  public String aaLU;
  public gmp abLE;
  public String abyJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153307);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaLU == null)
      {
        paramVarArgs = new b("Not all required fields were included: WxaUserName");
        AppMethodBeat.o(153307);
        throw paramVarArgs;
      }
      if (this.aaLU != null) {
        paramVarArgs.g(1, this.aaLU);
      }
      if (this.abLE != null)
      {
        paramVarArgs.qD(2, this.abLE.computeSize());
        this.abLE.writeFields(paramVarArgs);
      }
      if (this.abyJ != null) {
        paramVarArgs.g(3, this.abyJ);
      }
      AppMethodBeat.o(153307);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aaLU == null) {
        break label452;
      }
    }
    label452:
    for (int i = i.a.a.b.b.a.h(1, this.aaLU) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abLE != null) {
        paramInt = i + i.a.a.a.qC(2, this.abLE.computeSize());
      }
      i = paramInt;
      if (this.abyJ != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.abyJ);
      }
      AppMethodBeat.o(153307);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.aaLU == null)
        {
          paramVarArgs = new b("Not all required fields were included: WxaUserName");
          AppMethodBeat.o(153307);
          throw paramVarArgs;
        }
        AppMethodBeat.o(153307);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        flc localflc = (flc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153307);
          return -1;
        case 1: 
          localflc.aaLU = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(153307);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            gmp localgmp = new gmp();
            if ((localObject != null) && (localObject.length > 0)) {
              localgmp.parseFrom((byte[])localObject);
            }
            localflc.abLE = localgmp;
            paramInt += 1;
          }
          AppMethodBeat.o(153307);
          return 0;
        }
        localflc.abyJ = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(153307);
        return 0;
      }
      AppMethodBeat.o(153307);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.flc
 * JD-Core Version:    0.7.0.1
 */