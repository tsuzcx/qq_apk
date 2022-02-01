package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class don
  extends com.tencent.mm.bx.a
{
  public int CreateTime;
  public etl YFF;
  public String YFJ;
  public String ZaR;
  public int aaVx;
  public String nUB;
  public int vhJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43104);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YFF == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(43104);
        throw paramVarArgs;
      }
      if (this.YFF != null)
      {
        paramVarArgs.qD(1, this.YFF.computeSize());
        this.YFF.writeFields(paramVarArgs);
      }
      if (this.nUB != null) {
        paramVarArgs.g(2, this.nUB);
      }
      paramVarArgs.bS(3, this.vhJ);
      paramVarArgs.bS(4, this.CreateTime);
      paramVarArgs.bS(5, this.aaVx);
      if (this.YFJ != null) {
        paramVarArgs.g(6, this.YFJ);
      }
      if (this.ZaR != null) {
        paramVarArgs.g(9, this.ZaR);
      }
      AppMethodBeat.o(43104);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YFF == null) {
        break label652;
      }
    }
    label652:
    for (paramInt = i.a.a.a.qC(1, this.YFF.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nUB != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.nUB);
      }
      i = i + i.a.a.b.b.a.cJ(3, this.vhJ) + i.a.a.b.b.a.cJ(4, this.CreateTime) + i.a.a.b.b.a.cJ(5, this.aaVx);
      paramInt = i;
      if (this.YFJ != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.YFJ);
      }
      i = paramInt;
      if (this.ZaR != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.ZaR);
      }
      AppMethodBeat.o(43104);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.YFF == null)
        {
          paramVarArgs = new b("Not all required fields were included: ToUserName");
          AppMethodBeat.o(43104);
          throw paramVarArgs;
        }
        AppMethodBeat.o(43104);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        don localdon = (don)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 7: 
        case 8: 
        default: 
          AppMethodBeat.o(43104);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            etl localetl = new etl();
            if ((localObject != null) && (localObject.length > 0)) {
              localetl.dh((byte[])localObject);
            }
            localdon.YFF = localetl;
            paramInt += 1;
          }
          AppMethodBeat.o(43104);
          return 0;
        case 2: 
          localdon.nUB = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(43104);
          return 0;
        case 3: 
          localdon.vhJ = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(43104);
          return 0;
        case 4: 
          localdon.CreateTime = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(43104);
          return 0;
        case 5: 
          localdon.aaVx = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(43104);
          return 0;
        case 6: 
          localdon.YFJ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(43104);
          return 0;
        }
        localdon.ZaR = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(43104);
        return 0;
      }
      AppMethodBeat.o(43104);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.don
 * JD-Core Version:    0.7.0.1
 */