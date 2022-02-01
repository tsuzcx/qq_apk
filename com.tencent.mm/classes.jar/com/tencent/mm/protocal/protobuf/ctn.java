package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ctn
  extends com.tencent.mm.bx.a
{
  public String AesKey;
  public int CNt;
  public String CzY;
  public int DLD;
  public ble DLE;
  public String DLH;
  public String DVb;
  public int Dym;
  public int Eli;
  public String Elj;
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
      paramVarArgs.aR(2, this.CNt);
      paramVarArgs.aR(3, this.Scene);
      if (this.DLH != null) {
        paramVarArgs.d(4, this.DLH);
      }
      if (this.CzY != null) {
        paramVarArgs.d(5, this.CzY);
      }
      paramVarArgs.aR(6, this.DLD);
      if (this.DLE != null)
      {
        paramVarArgs.kX(7, this.DLE.computeSize());
        this.DLE.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(8, this.Eli);
      if (this.DVb != null) {
        paramVarArgs.d(9, this.DVb);
      }
      paramVarArgs.aR(10, this.Dym);
      if (this.Elj != null) {
        paramVarArgs.d(11, this.Elj);
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
      int i = paramInt + f.a.a.b.b.a.bA(2, this.CNt) + f.a.a.b.b.a.bA(3, this.Scene);
      paramInt = i;
      if (this.DLH != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DLH);
      }
      i = paramInt;
      if (this.CzY != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.CzY);
      }
      i += f.a.a.b.b.a.bA(6, this.DLD);
      paramInt = i;
      if (this.DLE != null) {
        paramInt = i + f.a.a.a.kW(7, this.DLE.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(8, this.Eli);
      paramInt = i;
      if (this.DVb != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.DVb);
      }
      i = paramInt + f.a.a.b.b.a.bA(10, this.Dym);
      paramInt = i;
      if (this.Elj != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.Elj);
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
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(117925);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ctn localctn = (ctn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117925);
          return -1;
        case 1: 
          localctn.Md5 = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(117925);
          return 0;
        case 2: 
          localctn.CNt = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(117925);
          return 0;
        case 3: 
          localctn.Scene = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(117925);
          return 0;
        case 4: 
          localctn.DLH = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(117925);
          return 0;
        case 5: 
          localctn.CzY = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(117925);
          return 0;
        case 6: 
          localctn.DLD = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(117925);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ble();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ble)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localctn.DLE = ((ble)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117925);
          return 0;
        case 8: 
          localctn.Eli = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(117925);
          return 0;
        case 9: 
          localctn.DVb = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(117925);
          return 0;
        case 10: 
          localctn.Dym = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(117925);
          return 0;
        case 11: 
          localctn.Elj = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(117925);
          return 0;
        }
        localctn.AesKey = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(117925);
        return 0;
      }
      AppMethodBeat.o(117925);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctn
 * JD-Core Version:    0.7.0.1
 */