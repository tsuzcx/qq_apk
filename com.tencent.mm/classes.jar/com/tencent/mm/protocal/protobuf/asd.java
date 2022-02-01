package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class asd
  extends com.tencent.mm.bw.a
{
  public String DUV;
  public long GIB;
  public String GIC;
  public int GID;
  public int GIE;
  public b GIF;
  public boolean GIG;
  public int GIH;
  public boolean GII;
  public int GIJ;
  public LinkedList<FinderObject> object;
  public int sgH;
  public String sjR;
  
  public asd()
  {
    AppMethodBeat.i(189402);
    this.object = new LinkedList();
    AppMethodBeat.o(189402);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(189403);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.GIB);
      if (this.DUV != null) {
        paramVarArgs.d(2, this.DUV);
      }
      if (this.GIC != null) {
        paramVarArgs.d(3, this.GIC);
      }
      paramVarArgs.aS(4, this.GID);
      paramVarArgs.e(5, 8, this.object);
      paramVarArgs.aS(6, this.GIE);
      if (this.GIF != null) {
        paramVarArgs.c(7, this.GIF);
      }
      paramVarArgs.aS(8, this.sgH);
      paramVarArgs.bC(9, this.GIG);
      paramVarArgs.aS(10, this.GIH);
      paramVarArgs.bC(11, this.GII);
      if (this.sjR != null) {
        paramVarArgs.d(12, this.sjR);
      }
      paramVarArgs.aS(13, this.GIJ);
      AppMethodBeat.o(189403);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.GIB) + 0;
      paramInt = i;
      if (this.DUV != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DUV);
      }
      i = paramInt;
      if (this.GIC != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GIC);
      }
      i = i + f.a.a.b.b.a.bz(4, this.GID) + f.a.a.a.c(5, 8, this.object) + f.a.a.b.b.a.bz(6, this.GIE);
      paramInt = i;
      if (this.GIF != null) {
        paramInt = i + f.a.a.b.b.a.b(7, this.GIF);
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.sgH) + f.a.a.b.b.a.amF(9) + f.a.a.b.b.a.bz(10, this.GIH) + f.a.a.b.b.a.amF(11);
      paramInt = i;
      if (this.sjR != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.sjR);
      }
      i = f.a.a.b.b.a.bz(13, this.GIJ);
      AppMethodBeat.o(189403);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.object.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(189403);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      asd localasd = (asd)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(189403);
        return -1;
      case 1: 
        localasd.GIB = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(189403);
        return 0;
      case 2: 
        localasd.DUV = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(189403);
        return 0;
      case 3: 
        localasd.GIC = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(189403);
        return 0;
      case 4: 
        localasd.GID = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(189403);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new FinderObject();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localasd.object.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(189403);
        return 0;
      case 6: 
        localasd.GIE = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(189403);
        return 0;
      case 7: 
        localasd.GIF = ((f.a.a.a.a)localObject1).OmT.gCk();
        AppMethodBeat.o(189403);
        return 0;
      case 8: 
        localasd.sgH = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(189403);
        return 0;
      case 9: 
        localasd.GIG = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(189403);
        return 0;
      case 10: 
        localasd.GIH = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(189403);
        return 0;
      case 11: 
        localasd.GII = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(189403);
        return 0;
      case 12: 
        localasd.sjR = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(189403);
        return 0;
      }
      localasd.GIJ = ((f.a.a.a.a)localObject1).OmT.zc();
      AppMethodBeat.o(189403);
      return 0;
    }
    AppMethodBeat.o(189403);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.asd
 * JD-Core Version:    0.7.0.1
 */