package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class mv
  extends com.tencent.mm.bw.a
{
  public LinkedList<dvc> EbY;
  public LinkedList<String> Eca;
  public String Ecb;
  public String Ecc;
  
  public mv()
  {
    AppMethodBeat.i(209566);
    this.EbY = new LinkedList();
    this.Eca = new LinkedList();
    AppMethodBeat.o(209566);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209567);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(15, 8, this.EbY);
      paramVarArgs.e(17, 1, this.Eca);
      if (this.Ecb != null) {
        paramVarArgs.d(18, this.Ecb);
      }
      if (this.Ecc != null) {
        paramVarArgs.d(19, this.Ecc);
      }
      AppMethodBeat.o(209567);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(15, 8, this.EbY) + 0 + f.a.a.a.c(17, 1, this.Eca);
      paramInt = i;
      if (this.Ecb != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.Ecb);
      }
      i = paramInt;
      if (this.Ecc != null) {
        i = paramInt + f.a.a.b.b.a.e(19, this.Ecc);
      }
      AppMethodBeat.o(209567);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.EbY.clear();
      this.Eca.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(209567);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      mv localmv = (mv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      case 16: 
      default: 
        AppMethodBeat.o(209567);
        return -1;
      case 15: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dvc();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dvc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localmv.EbY.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209567);
        return 0;
      case 17: 
        localmv.Eca.add(((f.a.a.a.a)localObject1).LVo.readString());
        AppMethodBeat.o(209567);
        return 0;
      case 18: 
        localmv.Ecb = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(209567);
        return 0;
      }
      localmv.Ecc = ((f.a.a.a.a)localObject1).LVo.readString();
      AppMethodBeat.o(209567);
      return 0;
    }
    AppMethodBeat.o(209567);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mv
 * JD-Core Version:    0.7.0.1
 */