package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class bkn
  extends com.tencent.mm.cd.a
{
  public int CKC;
  public String HpB;
  public int SVA;
  public int SVs;
  public int SVt;
  public b SVu;
  public LinkedList<String> SVv;
  public abd SVw;
  public int SVx;
  public int SVy;
  public int SVz;
  public int count;
  public String path;
  public String title;
  public String ufC;
  
  public bkn()
  {
    AppMethodBeat.i(198760);
    this.SVv = new LinkedList();
    AppMethodBeat.o(198760);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184212);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.CKC);
      paramVarArgs.aY(2, this.count);
      if (this.title != null) {
        paramVarArgs.f(3, this.title);
      }
      if (this.ufC != null) {
        paramVarArgs.f(4, this.ufC);
      }
      paramVarArgs.aY(5, this.SVs);
      if (this.path != null) {
        paramVarArgs.f(6, this.path);
      }
      if (this.HpB != null) {
        paramVarArgs.f(7, this.HpB);
      }
      paramVarArgs.aY(8, this.SVt);
      if (this.SVu != null) {
        paramVarArgs.c(9, this.SVu);
      }
      paramVarArgs.e(10, 1, this.SVv);
      if (this.SVw != null)
      {
        paramVarArgs.oE(11, this.SVw.computeSize());
        this.SVw.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(12, this.SVx);
      paramVarArgs.aY(13, this.SVy);
      paramVarArgs.aY(14, this.SVz);
      paramVarArgs.aY(15, this.SVA);
      AppMethodBeat.o(184212);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.CKC) + 0 + g.a.a.b.b.a.bM(2, this.count);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.title);
      }
      i = paramInt;
      if (this.ufC != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.ufC);
      }
      i += g.a.a.b.b.a.bM(5, this.SVs);
      paramInt = i;
      if (this.path != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.path);
      }
      i = paramInt;
      if (this.HpB != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.HpB);
      }
      i += g.a.a.b.b.a.bM(8, this.SVt);
      paramInt = i;
      if (this.SVu != null) {
        paramInt = i + g.a.a.b.b.a.b(9, this.SVu);
      }
      i = paramInt + g.a.a.a.c(10, 1, this.SVv);
      paramInt = i;
      if (this.SVw != null) {
        paramInt = i + g.a.a.a.oD(11, this.SVw.computeSize());
      }
      i = g.a.a.b.b.a.bM(12, this.SVx);
      int j = g.a.a.b.b.a.bM(13, this.SVy);
      int k = g.a.a.b.b.a.bM(14, this.SVz);
      int m = g.a.a.b.b.a.bM(15, this.SVA);
      AppMethodBeat.o(184212);
      return paramInt + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.SVv.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(184212);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      bkn localbkn = (bkn)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(184212);
        return -1;
      case 1: 
        localbkn.CKC = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(184212);
        return 0;
      case 2: 
        localbkn.count = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(184212);
        return 0;
      case 3: 
        localbkn.title = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(184212);
        return 0;
      case 4: 
        localbkn.ufC = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(184212);
        return 0;
      case 5: 
        localbkn.SVs = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(184212);
        return 0;
      case 6: 
        localbkn.path = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(184212);
        return 0;
      case 7: 
        localbkn.HpB = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(184212);
        return 0;
      case 8: 
        localbkn.SVt = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(184212);
        return 0;
      case 9: 
        localbkn.SVu = ((g.a.a.a.a)localObject).abFh.iUw();
        AppMethodBeat.o(184212);
        return 0;
      case 10: 
        localbkn.SVv.add(((g.a.a.a.a)localObject).abFh.readString());
        AppMethodBeat.o(184212);
        return 0;
      case 11: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          abd localabd = new abd();
          if ((localObject != null) && (localObject.length > 0)) {
            localabd.parseFrom((byte[])localObject);
          }
          localbkn.SVw = localabd;
          paramInt += 1;
        }
        AppMethodBeat.o(184212);
        return 0;
      case 12: 
        localbkn.SVx = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(184212);
        return 0;
      case 13: 
        localbkn.SVy = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(184212);
        return 0;
      case 14: 
        localbkn.SVz = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(184212);
        return 0;
      }
      localbkn.SVA = ((g.a.a.a.a)localObject).abFh.AK();
      AppMethodBeat.o(184212);
      return 0;
    }
    AppMethodBeat.o(184212);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkn
 * JD-Core Version:    0.7.0.1
 */