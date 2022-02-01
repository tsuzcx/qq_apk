package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class duc
  extends com.tencent.mm.bw.a
{
  public String DRR;
  public int LaB;
  public LinkedList<eif> MVN;
  public String aesKey;
  public int iFw;
  public int jqS;
  public String md5;
  public int thumbHeight;
  public int thumbWidth;
  public String url;
  
  public duc()
  {
    AppMethodBeat.i(127174);
    this.MVN = new LinkedList();
    AppMethodBeat.o(127174);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127175);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.DRR == null)
      {
        paramVarArgs = new b("Not all required fields were included: clientID");
        AppMethodBeat.o(127175);
        throw paramVarArgs;
      }
      paramVarArgs.e(1, 8, this.MVN);
      if (this.DRR != null) {
        paramVarArgs.e(2, this.DRR);
      }
      if (this.md5 != null) {
        paramVarArgs.e(3, this.md5);
      }
      if (this.aesKey != null) {
        paramVarArgs.e(4, this.aesKey);
      }
      if (this.url != null) {
        paramVarArgs.e(5, this.url);
      }
      paramVarArgs.aM(6, this.iFw);
      paramVarArgs.aM(7, this.jqS);
      paramVarArgs.aM(8, this.LaB);
      paramVarArgs.aM(9, this.thumbHeight);
      paramVarArgs.aM(10, this.thumbWidth);
      AppMethodBeat.o(127175);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.MVN) + 0;
      paramInt = i;
      if (this.DRR != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.DRR);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.md5);
      }
      paramInt = i;
      if (this.aesKey != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.aesKey);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.url);
      }
      paramInt = g.a.a.b.b.a.bu(6, this.iFw);
      int j = g.a.a.b.b.a.bu(7, this.jqS);
      int k = g.a.a.b.b.a.bu(8, this.LaB);
      int m = g.a.a.b.b.a.bu(9, this.thumbHeight);
      int n = g.a.a.b.b.a.bu(10, this.thumbWidth);
      AppMethodBeat.o(127175);
      return i + paramInt + j + k + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.MVN.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      if (this.DRR == null)
      {
        paramVarArgs = new b("Not all required fields were included: clientID");
        AppMethodBeat.o(127175);
        throw paramVarArgs;
      }
      AppMethodBeat.o(127175);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      duc localduc = (duc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(127175);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new eif();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((eif)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localduc.MVN.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(127175);
        return 0;
      case 2: 
        localduc.DRR = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(127175);
        return 0;
      case 3: 
        localduc.md5 = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(127175);
        return 0;
      case 4: 
        localduc.aesKey = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(127175);
        return 0;
      case 5: 
        localduc.url = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(127175);
        return 0;
      case 6: 
        localduc.iFw = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(127175);
        return 0;
      case 7: 
        localduc.jqS = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(127175);
        return 0;
      case 8: 
        localduc.LaB = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(127175);
        return 0;
      case 9: 
        localduc.thumbHeight = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(127175);
        return 0;
      }
      localduc.thumbWidth = ((g.a.a.a.a)localObject1).UbS.zi();
      AppMethodBeat.o(127175);
      return 0;
    }
    AppMethodBeat.o(127175);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.duc
 * JD-Core Version:    0.7.0.1
 */