package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dae
  extends com.tencent.mm.bx.a
{
  public int FNy;
  public LinkedList<dnm> Hqz;
  public String gjI;
  public int hHQ;
  public int isM;
  public String md5;
  public int thumbHeight;
  public int thumbWidth;
  public String url;
  public String zqB;
  
  public dae()
  {
    AppMethodBeat.i(127174);
    this.Hqz = new LinkedList();
    AppMethodBeat.o(127174);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127175);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.zqB == null)
      {
        paramVarArgs = new b("Not all required fields were included: clientID");
        AppMethodBeat.o(127175);
        throw paramVarArgs;
      }
      paramVarArgs.e(1, 8, this.Hqz);
      if (this.zqB != null) {
        paramVarArgs.d(2, this.zqB);
      }
      if (this.md5 != null) {
        paramVarArgs.d(3, this.md5);
      }
      if (this.gjI != null) {
        paramVarArgs.d(4, this.gjI);
      }
      if (this.url != null) {
        paramVarArgs.d(5, this.url);
      }
      paramVarArgs.aS(6, this.hHQ);
      paramVarArgs.aS(7, this.isM);
      paramVarArgs.aS(8, this.FNy);
      paramVarArgs.aS(9, this.thumbHeight);
      paramVarArgs.aS(10, this.thumbWidth);
      AppMethodBeat.o(127175);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.Hqz) + 0;
      paramInt = i;
      if (this.zqB != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.zqB);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.md5);
      }
      paramInt = i;
      if (this.gjI != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.gjI);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.url);
      }
      paramInt = f.a.a.b.b.a.bz(6, this.hHQ);
      int j = f.a.a.b.b.a.bz(7, this.isM);
      int k = f.a.a.b.b.a.bz(8, this.FNy);
      int m = f.a.a.b.b.a.bz(9, this.thumbHeight);
      int n = f.a.a.b.b.a.bz(10, this.thumbWidth);
      AppMethodBeat.o(127175);
      return i + paramInt + j + k + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Hqz.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      if (this.zqB == null)
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
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dae localdae = (dae)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(127175);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dnm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dnm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdae.Hqz.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(127175);
        return 0;
      case 2: 
        localdae.zqB = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(127175);
        return 0;
      case 3: 
        localdae.md5 = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(127175);
        return 0;
      case 4: 
        localdae.gjI = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(127175);
        return 0;
      case 5: 
        localdae.url = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(127175);
        return 0;
      case 6: 
        localdae.hHQ = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(127175);
        return 0;
      case 7: 
        localdae.isM = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(127175);
        return 0;
      case 8: 
        localdae.FNy = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(127175);
        return 0;
      case 9: 
        localdae.thumbHeight = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(127175);
        return 0;
      }
      localdae.thumbWidth = ((f.a.a.a.a)localObject1).NPN.zc();
      AppMethodBeat.o(127175);
      return 0;
    }
    AppMethodBeat.o(127175);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dae
 * JD-Core Version:    0.7.0.1
 */