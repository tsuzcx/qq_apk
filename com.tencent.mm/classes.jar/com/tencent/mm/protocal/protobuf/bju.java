package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bju
  extends com.tencent.mm.bx.a
{
  public boolean DHT;
  public cig DHU;
  public String doh;
  public String tfH;
  public String tfI;
  public String title;
  public int uaQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91528);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.uaQ);
      paramVarArgs.bg(2, this.DHT);
      if (this.doh != null) {
        paramVarArgs.d(3, this.doh);
      }
      if (this.tfH != null) {
        paramVarArgs.d(4, this.tfH);
      }
      if (this.tfI != null) {
        paramVarArgs.d(5, this.tfI);
      }
      if (this.DHU != null)
      {
        paramVarArgs.kX(6, this.DHU.computeSize());
        this.DHU.writeFields(paramVarArgs);
      }
      if (this.title != null) {
        paramVarArgs.d(7, this.title);
      }
      AppMethodBeat.o(91528);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.uaQ) + 0 + (f.a.a.b.b.a.fY(2) + 1);
      paramInt = i;
      if (this.doh != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.doh);
      }
      i = paramInt;
      if (this.tfH != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.tfH);
      }
      paramInt = i;
      if (this.tfI != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.tfI);
      }
      i = paramInt;
      if (this.DHU != null) {
        i = paramInt + f.a.a.a.kW(6, this.DHU.computeSize());
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.title);
      }
      AppMethodBeat.o(91528);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(91528);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      bju localbju = (bju)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91528);
        return -1;
      case 1: 
        localbju.uaQ = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91528);
        return 0;
      case 2: 
        localbju.DHT = ((f.a.a.a.a)localObject1).KhF.fHu();
        AppMethodBeat.o(91528);
        return 0;
      case 3: 
        localbju.doh = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91528);
        return 0;
      case 4: 
        localbju.tfH = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91528);
        return 0;
      case 5: 
        localbju.tfI = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91528);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cig();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cig)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbju.DHU = ((cig)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91528);
        return 0;
      }
      localbju.title = ((f.a.a.a.a)localObject1).KhF.readString();
      AppMethodBeat.o(91528);
      return 0;
    }
    AppMethodBeat.o(91528);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bju
 * JD-Core Version:    0.7.0.1
 */