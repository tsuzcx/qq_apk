package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dnw
  extends com.tencent.mm.bx.a
{
  public int HBO;
  public int HBP;
  public String HBQ;
  public dnv HBR;
  public boolean dmo;
  public int htQ;
  public String id;
  public String kPR;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153001);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HBO);
      paramVarArgs.aS(2, this.htQ);
      paramVarArgs.aS(3, this.HBP);
      paramVarArgs.aS(4, this.type);
      if (this.id != null) {
        paramVarArgs.d(5, this.id);
      }
      if (this.kPR != null) {
        paramVarArgs.d(6, this.kPR);
      }
      if (this.HBQ != null) {
        paramVarArgs.d(7, this.HBQ);
      }
      if (this.HBR != null)
      {
        paramVarArgs.lC(8, this.HBR.computeSize());
        this.HBR.writeFields(paramVarArgs);
      }
      paramVarArgs.bt(9, this.dmo);
      AppMethodBeat.o(153001);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.HBO) + 0 + f.a.a.b.b.a.bz(2, this.htQ) + f.a.a.b.b.a.bz(3, this.HBP) + f.a.a.b.b.a.bz(4, this.type);
      paramInt = i;
      if (this.id != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.id);
      }
      i = paramInt;
      if (this.kPR != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.kPR);
      }
      paramInt = i;
      if (this.HBQ != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.HBQ);
      }
      i = paramInt;
      if (this.HBR != null) {
        i = paramInt + f.a.a.a.lB(8, this.HBR.computeSize());
      }
      paramInt = f.a.a.b.b.a.alV(9);
      AppMethodBeat.o(153001);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(153001);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dnw localdnw = (dnw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(153001);
        return -1;
      case 1: 
        localdnw.HBO = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(153001);
        return 0;
      case 2: 
        localdnw.htQ = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(153001);
        return 0;
      case 3: 
        localdnw.HBP = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(153001);
        return 0;
      case 4: 
        localdnw.type = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(153001);
        return 0;
      case 5: 
        localdnw.id = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(153001);
        return 0;
      case 6: 
        localdnw.kPR = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(153001);
        return 0;
      case 7: 
        localdnw.HBQ = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(153001);
        return 0;
      case 8: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dnv();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dnv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdnw.HBR = ((dnv)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(153001);
        return 0;
      }
      localdnw.dmo = ((f.a.a.a.a)localObject1).NPN.grw();
      AppMethodBeat.o(153001);
      return 0;
    }
    AppMethodBeat.o(153001);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnw
 * JD-Core Version:    0.7.0.1
 */