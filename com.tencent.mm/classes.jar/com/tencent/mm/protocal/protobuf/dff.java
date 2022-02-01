package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dff
  extends com.tencent.mm.bw.a
{
  public String AesKey;
  public String FQl;
  public int GWA;
  public int GWF;
  public int GeT;
  public int HMr;
  public String HMs;
  public buh HkU;
  public String HkY;
  public String Hvt;
  public String Md5;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117925);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Md5 != null) {
        paramVarArgs.d(1, this.Md5);
      }
      paramVarArgs.aS(2, this.GeT);
      paramVarArgs.aS(3, this.Scene);
      if (this.HkY != null) {
        paramVarArgs.d(4, this.HkY);
      }
      if (this.FQl != null) {
        paramVarArgs.d(5, this.FQl);
      }
      paramVarArgs.aS(6, this.GWA);
      if (this.HkU != null)
      {
        paramVarArgs.lJ(7, this.HkU.computeSize());
        this.HkU.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(8, this.HMr);
      if (this.Hvt != null) {
        paramVarArgs.d(9, this.Hvt);
      }
      paramVarArgs.aS(10, this.GWF);
      if (this.HMs != null) {
        paramVarArgs.d(11, this.HMs);
      }
      if (this.AesKey != null) {
        paramVarArgs.d(12, this.AesKey);
      }
      AppMethodBeat.o(117925);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Md5 == null) {
        break label902;
      }
    }
    label902:
    for (paramInt = f.a.a.b.b.a.e(1, this.Md5) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.GeT) + f.a.a.b.b.a.bz(3, this.Scene);
      paramInt = i;
      if (this.HkY != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HkY);
      }
      i = paramInt;
      if (this.FQl != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FQl);
      }
      i += f.a.a.b.b.a.bz(6, this.GWA);
      paramInt = i;
      if (this.HkU != null) {
        paramInt = i + f.a.a.a.lI(7, this.HkU.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.HMr);
      paramInt = i;
      if (this.Hvt != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Hvt);
      }
      i = paramInt + f.a.a.b.b.a.bz(10, this.GWF);
      paramInt = i;
      if (this.HMs != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.HMs);
      }
      i = paramInt;
      if (this.AesKey != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.AesKey);
      }
      AppMethodBeat.o(117925);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(117925);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dff localdff = (dff)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117925);
          return -1;
        case 1: 
          localdff.Md5 = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(117925);
          return 0;
        case 2: 
          localdff.GeT = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(117925);
          return 0;
        case 3: 
          localdff.Scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(117925);
          return 0;
        case 4: 
          localdff.HkY = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(117925);
          return 0;
        case 5: 
          localdff.FQl = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(117925);
          return 0;
        case 6: 
          localdff.GWA = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(117925);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new buh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((buh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdff.HkU = ((buh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117925);
          return 0;
        case 8: 
          localdff.HMr = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(117925);
          return 0;
        case 9: 
          localdff.Hvt = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(117925);
          return 0;
        case 10: 
          localdff.GWF = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(117925);
          return 0;
        case 11: 
          localdff.HMs = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(117925);
          return 0;
        }
        localdff.AesKey = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(117925);
        return 0;
      }
      AppMethodBeat.o(117925);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dff
 * JD-Core Version:    0.7.0.1
 */