package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ajv
  extends com.tencent.mm.bx.a
{
  public String FCb;
  public ajw Gjn;
  public String doK;
  public int duration;
  public String hDe;
  public String hDm;
  public int hzh = -1;
  public int hzi;
  public int hzj = 0;
  public int hzk;
  public int hzl;
  public String hzm;
  public int videoHeight;
  public String videoUrl;
  public int videoWidth;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127467);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.hzh);
      paramVarArgs.aS(2, this.hzj);
      paramVarArgs.aS(3, this.videoWidth);
      paramVarArgs.aS(4, this.videoHeight);
      paramVarArgs.aS(5, this.hzi);
      paramVarArgs.aS(6, this.duration);
      if (this.hzm != null) {
        paramVarArgs.d(7, this.hzm);
      }
      if (this.doK != null) {
        paramVarArgs.d(8, this.doK);
      }
      if (this.hDe != null) {
        paramVarArgs.d(9, this.hDe);
      }
      paramVarArgs.aS(10, this.hzl);
      if (this.Gjn != null)
      {
        paramVarArgs.lC(11, this.Gjn.computeSize());
        this.Gjn.writeFields(paramVarArgs);
      }
      if (this.hDm != null) {
        paramVarArgs.d(12, this.hDm);
      }
      if (this.FCb != null) {
        paramVarArgs.d(13, this.FCb);
      }
      if (this.videoUrl != null) {
        paramVarArgs.d(14, this.videoUrl);
      }
      paramVarArgs.aS(15, this.hzk);
      AppMethodBeat.o(127467);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.hzh) + 0 + f.a.a.b.b.a.bz(2, this.hzj) + f.a.a.b.b.a.bz(3, this.videoWidth) + f.a.a.b.b.a.bz(4, this.videoHeight) + f.a.a.b.b.a.bz(5, this.hzi) + f.a.a.b.b.a.bz(6, this.duration);
      paramInt = i;
      if (this.hzm != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.hzm);
      }
      i = paramInt;
      if (this.doK != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.doK);
      }
      paramInt = i;
      if (this.hDe != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.hDe);
      }
      i = paramInt + f.a.a.b.b.a.bz(10, this.hzl);
      paramInt = i;
      if (this.Gjn != null) {
        paramInt = i + f.a.a.a.lB(11, this.Gjn.computeSize());
      }
      i = paramInt;
      if (this.hDm != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.hDm);
      }
      paramInt = i;
      if (this.FCb != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.FCb);
      }
      i = paramInt;
      if (this.videoUrl != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.videoUrl);
      }
      paramInt = f.a.a.b.b.a.bz(15, this.hzk);
      AppMethodBeat.o(127467);
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
      AppMethodBeat.o(127467);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ajv localajv = (ajv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(127467);
        return -1;
      case 1: 
        localajv.hzh = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(127467);
        return 0;
      case 2: 
        localajv.hzj = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(127467);
        return 0;
      case 3: 
        localajv.videoWidth = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(127467);
        return 0;
      case 4: 
        localajv.videoHeight = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(127467);
        return 0;
      case 5: 
        localajv.hzi = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(127467);
        return 0;
      case 6: 
        localajv.duration = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(127467);
        return 0;
      case 7: 
        localajv.hzm = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(127467);
        return 0;
      case 8: 
        localajv.doK = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(127467);
        return 0;
      case 9: 
        localajv.hDe = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(127467);
        return 0;
      case 10: 
        localajv.hzl = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(127467);
        return 0;
      case 11: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ajw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ajw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localajv.Gjn = ((ajw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(127467);
        return 0;
      case 12: 
        localajv.hDm = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(127467);
        return 0;
      case 13: 
        localajv.FCb = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(127467);
        return 0;
      case 14: 
        localajv.videoUrl = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(127467);
        return 0;
      }
      localajv.hzk = ((f.a.a.a.a)localObject1).NPN.zc();
      AppMethodBeat.o(127467);
      return 0;
    }
    AppMethodBeat.o(127467);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajv
 * JD-Core Version:    0.7.0.1
 */