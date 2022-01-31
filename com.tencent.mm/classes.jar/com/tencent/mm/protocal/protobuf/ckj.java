package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ckj
  extends com.tencent.mm.bv.a
{
  public String Md5;
  public int Version;
  public int jKs;
  public int wLx;
  public String wXS;
  public String wyV;
  public int xIP;
  public LinkedList<cki> xUm;
  public boolean xUn;
  public LinkedList<ckk> xUo;
  public String xUp;
  
  public ckj()
  {
    AppMethodBeat.i(14756);
    this.xUm = new LinkedList();
    this.xUo = new LinkedList();
    AppMethodBeat.o(14756);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(14757);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.jKs);
      paramVarArgs.aO(2, this.Version);
      if (this.wyV != null) {
        paramVarArgs.e(3, this.wyV);
      }
      if (this.Md5 != null) {
        paramVarArgs.e(4, this.Md5);
      }
      paramVarArgs.aO(5, this.wLx);
      paramVarArgs.aO(6, this.xIP);
      paramVarArgs.e(7, 8, this.xUm);
      paramVarArgs.aS(8, this.xUn);
      if (this.wXS != null) {
        paramVarArgs.e(9, this.wXS);
      }
      paramVarArgs.e(10, 8, this.xUo);
      if (this.xUp != null) {
        paramVarArgs.e(11, this.xUp);
      }
      AppMethodBeat.o(14757);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.jKs) + 0 + e.a.a.b.b.a.bl(2, this.Version);
      paramInt = i;
      if (this.wyV != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.wyV);
      }
      i = paramInt;
      if (this.Md5 != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.Md5);
      }
      i = i + e.a.a.b.b.a.bl(5, this.wLx) + e.a.a.b.b.a.bl(6, this.xIP) + e.a.a.a.c(7, 8, this.xUm) + (e.a.a.b.b.a.eW(8) + 1);
      paramInt = i;
      if (this.wXS != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.wXS);
      }
      i = paramInt + e.a.a.a.c(10, 8, this.xUo);
      paramInt = i;
      if (this.xUp != null) {
        paramInt = i + e.a.a.b.b.a.f(11, this.xUp);
      }
      AppMethodBeat.o(14757);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.xUm.clear();
      this.xUo.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(14757);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      ckj localckj = (ckj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(14757);
        return -1;
      case 1: 
        localckj.jKs = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(14757);
        return 0;
      case 2: 
        localckj.Version = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(14757);
        return 0;
      case 3: 
        localckj.wyV = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(14757);
        return 0;
      case 4: 
        localckj.Md5 = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(14757);
        return 0;
      case 5: 
        localckj.wLx = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(14757);
        return 0;
      case 6: 
        localckj.xIP = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(14757);
        return 0;
      case 7: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cki();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cki)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localckj.xUm.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(14757);
        return 0;
      case 8: 
        localckj.xUn = ((e.a.a.a.a)localObject1).CLY.emu();
        AppMethodBeat.o(14757);
        return 0;
      case 9: 
        localckj.wXS = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(14757);
        return 0;
      case 10: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ckk();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ckk)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localckj.xUo.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(14757);
        return 0;
      }
      localckj.xUp = ((e.a.a.a.a)localObject1).CLY.readString();
      AppMethodBeat.o(14757);
      return 0;
    }
    AppMethodBeat.o(14757);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckj
 * JD-Core Version:    0.7.0.1
 */