package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bxx
  extends com.tencent.mm.bw.a
{
  public int HkA;
  public float HkE;
  public float HkF;
  public String HkG;
  public LinkedList<String> HkH;
  public String HkI;
  public LinkedList<String> HkJ;
  public LinkedList<bxy> HkK;
  public LinkedList<bxv> HkL;
  public int HkM;
  public int duration;
  public int dwi;
  public String hGr;
  public String iWE;
  
  public bxx()
  {
    AppMethodBeat.i(169924);
    this.HkH = new LinkedList();
    this.HkJ = new LinkedList();
    this.HkK = new LinkedList();
    this.HkL = new LinkedList();
    this.HkM = 1;
    AppMethodBeat.o(169924);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169925);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HkG == null)
      {
        paramVarArgs = new b("Not all required fields were included: music_url");
        AppMethodBeat.o(169925);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.HkA);
      paramVarArgs.y(2, this.HkE);
      paramVarArgs.y(3, this.HkF);
      if (this.HkG != null) {
        paramVarArgs.d(4, this.HkG);
      }
      paramVarArgs.e(5, 1, this.HkH);
      if (this.HkI != null) {
        paramVarArgs.d(6, this.HkI);
      }
      paramVarArgs.e(7, 1, this.HkJ);
      paramVarArgs.e(8, 8, this.HkK);
      if (this.iWE != null) {
        paramVarArgs.d(9, this.iWE);
      }
      if (this.hGr != null) {
        paramVarArgs.d(10, this.hGr);
      }
      paramVarArgs.e(11, 8, this.HkL);
      paramVarArgs.aS(12, this.dwi);
      paramVarArgs.aS(13, this.duration);
      paramVarArgs.aS(14, this.HkM);
      AppMethodBeat.o(169925);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.HkA) + 0 + f.a.a.b.b.a.amE(2) + f.a.a.b.b.a.amE(3);
      paramInt = i;
      if (this.HkG != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HkG);
      }
      i = paramInt + f.a.a.a.c(5, 1, this.HkH);
      paramInt = i;
      if (this.HkI != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.HkI);
      }
      i = paramInt + f.a.a.a.c(7, 1, this.HkJ) + f.a.a.a.c(8, 8, this.HkK);
      paramInt = i;
      if (this.iWE != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.iWE);
      }
      i = paramInt;
      if (this.hGr != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.hGr);
      }
      paramInt = f.a.a.a.c(11, 8, this.HkL);
      int j = f.a.a.b.b.a.bz(12, this.dwi);
      int k = f.a.a.b.b.a.bz(13, this.duration);
      int m = f.a.a.b.b.a.bz(14, this.HkM);
      AppMethodBeat.o(169925);
      return i + paramInt + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.HkH.clear();
      this.HkJ.clear();
      this.HkK.clear();
      this.HkL.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      if (this.HkG == null)
      {
        paramVarArgs = new b("Not all required fields were included: music_url");
        AppMethodBeat.o(169925);
        throw paramVarArgs;
      }
      AppMethodBeat.o(169925);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      bxx localbxx = (bxx)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(169925);
        return -1;
      case 1: 
        localbxx.HkA = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(169925);
        return 0;
      case 2: 
        localbxx.HkE = Float.intBitsToFloat(((f.a.a.a.a)localObject1).OmT.gwb());
        AppMethodBeat.o(169925);
        return 0;
      case 3: 
        localbxx.HkF = Float.intBitsToFloat(((f.a.a.a.a)localObject1).OmT.gwb());
        AppMethodBeat.o(169925);
        return 0;
      case 4: 
        localbxx.HkG = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(169925);
        return 0;
      case 5: 
        localbxx.HkH.add(((f.a.a.a.a)localObject1).OmT.readString());
        AppMethodBeat.o(169925);
        return 0;
      case 6: 
        localbxx.HkI = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(169925);
        return 0;
      case 7: 
        localbxx.HkJ.add(((f.a.a.a.a)localObject1).OmT.readString());
        AppMethodBeat.o(169925);
        return 0;
      case 8: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bxy();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bxy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbxx.HkK.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169925);
        return 0;
      case 9: 
        localbxx.iWE = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(169925);
        return 0;
      case 10: 
        localbxx.hGr = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(169925);
        return 0;
      case 11: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bxv();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bxv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbxx.HkL.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169925);
        return 0;
      case 12: 
        localbxx.dwi = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(169925);
        return 0;
      case 13: 
        localbxx.duration = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(169925);
        return 0;
      }
      localbxx.HkM = ((f.a.a.a.a)localObject1).OmT.zc();
      AppMethodBeat.o(169925);
      return 0;
    }
    AppMethodBeat.o(169925);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxx
 * JD-Core Version:    0.7.0.1
 */