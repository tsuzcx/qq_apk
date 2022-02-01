package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class djz
  extends com.tencent.mm.bx.a
{
  public int CreateTime;
  public int HtG;
  public int HtH;
  public String HxL;
  public String HxM;
  public int HxO;
  public djs HxW;
  public long Id;
  public int IsNotRichText;
  public String ThumbUrl;
  public String hDa;
  public int nEf;
  public String uki;
  public String ukj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118472);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.Id);
      if (this.ukj != null) {
        paramVarArgs.d(2, this.ukj);
      }
      if (this.uki != null) {
        paramVarArgs.d(3, this.uki);
      }
      if (this.HxL != null) {
        paramVarArgs.d(4, this.HxL);
      }
      if (this.HxM != null) {
        paramVarArgs.d(5, this.HxM);
      }
      if (this.hDa != null) {
        paramVarArgs.d(6, this.hDa);
      }
      paramVarArgs.aS(7, this.nEf);
      paramVarArgs.aS(8, this.CreateTime);
      paramVarArgs.aS(9, this.HtH);
      paramVarArgs.aS(10, this.HtG);
      paramVarArgs.aS(11, this.IsNotRichText);
      if (this.ThumbUrl != null) {
        paramVarArgs.d(12, this.ThumbUrl);
      }
      if (this.HxW != null)
      {
        paramVarArgs.lC(13, this.HxW.computeSize());
        this.HxW.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(14, this.HxO);
      AppMethodBeat.o(118472);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.Id) + 0;
      paramInt = i;
      if (this.ukj != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ukj);
      }
      i = paramInt;
      if (this.uki != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.uki);
      }
      paramInt = i;
      if (this.HxL != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HxL);
      }
      i = paramInt;
      if (this.HxM != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.HxM);
      }
      paramInt = i;
      if (this.hDa != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.hDa);
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.nEf) + f.a.a.b.b.a.bz(8, this.CreateTime) + f.a.a.b.b.a.bz(9, this.HtH) + f.a.a.b.b.a.bz(10, this.HtG) + f.a.a.b.b.a.bz(11, this.IsNotRichText);
      paramInt = i;
      if (this.ThumbUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.ThumbUrl);
      }
      i = paramInt;
      if (this.HxW != null) {
        i = paramInt + f.a.a.a.lB(13, this.HxW.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(14, this.HxO);
      AppMethodBeat.o(118472);
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
      AppMethodBeat.o(118472);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      djz localdjz = (djz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(118472);
        return -1;
      case 1: 
        localdjz.Id = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(118472);
        return 0;
      case 2: 
        localdjz.ukj = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(118472);
        return 0;
      case 3: 
        localdjz.uki = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(118472);
        return 0;
      case 4: 
        localdjz.HxL = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(118472);
        return 0;
      case 5: 
        localdjz.HxM = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(118472);
        return 0;
      case 6: 
        localdjz.hDa = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(118472);
        return 0;
      case 7: 
        localdjz.nEf = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(118472);
        return 0;
      case 8: 
        localdjz.CreateTime = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(118472);
        return 0;
      case 9: 
        localdjz.HtH = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(118472);
        return 0;
      case 10: 
        localdjz.HtG = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(118472);
        return 0;
      case 11: 
        localdjz.IsNotRichText = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(118472);
        return 0;
      case 12: 
        localdjz.ThumbUrl = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(118472);
        return 0;
      case 13: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new djs();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((djs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdjz.HxW = ((djs)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118472);
        return 0;
      }
      localdjz.HxO = ((f.a.a.a.a)localObject1).NPN.zc();
      AppMethodBeat.o(118472);
      return 0;
    }
    AppMethodBeat.o(118472);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djz
 * JD-Core Version:    0.7.0.1
 */