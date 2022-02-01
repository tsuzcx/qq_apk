package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dyl
  extends com.tencent.mm.bw.a
{
  public String AesKey;
  public int KZk;
  public int MYb;
  public String MYc;
  public int MaY;
  public String Mba;
  public String Mbb;
  public int Mbn;
  public String Md5;
  public chl MlQ;
  public aah MlR;
  public int Scene;
  public String SessionId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117925);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Md5 != null) {
        paramVarArgs.e(1, this.Md5);
      }
      paramVarArgs.aM(2, this.KZk);
      paramVarArgs.aM(3, this.Scene);
      if (this.Mbb != null) {
        paramVarArgs.e(4, this.Mbb);
      }
      if (this.SessionId != null) {
        paramVarArgs.e(5, this.SessionId);
      }
      paramVarArgs.aM(6, this.MaY);
      if (this.MlQ != null)
      {
        paramVarArgs.ni(7, this.MlQ.computeSize());
        this.MlQ.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(8, this.MYb);
      if (this.Mba != null) {
        paramVarArgs.e(9, this.Mba);
      }
      paramVarArgs.aM(10, this.Mbn);
      if (this.MYc != null) {
        paramVarArgs.e(11, this.MYc);
      }
      if (this.AesKey != null) {
        paramVarArgs.e(12, this.AesKey);
      }
      if (this.MlR != null)
      {
        paramVarArgs.ni(13, this.MlR.computeSize());
        this.MlR.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(117925);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Md5 == null) {
        break label1058;
      }
    }
    label1058:
    for (paramInt = g.a.a.b.b.a.f(1, this.Md5) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.KZk) + g.a.a.b.b.a.bu(3, this.Scene);
      paramInt = i;
      if (this.Mbb != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Mbb);
      }
      i = paramInt;
      if (this.SessionId != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.SessionId);
      }
      i += g.a.a.b.b.a.bu(6, this.MaY);
      paramInt = i;
      if (this.MlQ != null) {
        paramInt = i + g.a.a.a.nh(7, this.MlQ.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(8, this.MYb);
      paramInt = i;
      if (this.Mba != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.Mba);
      }
      i = paramInt + g.a.a.b.b.a.bu(10, this.Mbn);
      paramInt = i;
      if (this.MYc != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.MYc);
      }
      i = paramInt;
      if (this.AesKey != null) {
        i = paramInt + g.a.a.b.b.a.f(12, this.AesKey);
      }
      paramInt = i;
      if (this.MlR != null) {
        paramInt = i + g.a.a.a.nh(13, this.MlR.computeSize());
      }
      AppMethodBeat.o(117925);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(117925);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dyl localdyl = (dyl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117925);
          return -1;
        case 1: 
          localdyl.Md5 = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(117925);
          return 0;
        case 2: 
          localdyl.KZk = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(117925);
          return 0;
        case 3: 
          localdyl.Scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(117925);
          return 0;
        case 4: 
          localdyl.Mbb = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(117925);
          return 0;
        case 5: 
          localdyl.SessionId = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(117925);
          return 0;
        case 6: 
          localdyl.MaY = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(117925);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new chl();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((chl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdyl.MlQ = ((chl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117925);
          return 0;
        case 8: 
          localdyl.MYb = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(117925);
          return 0;
        case 9: 
          localdyl.Mba = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(117925);
          return 0;
        case 10: 
          localdyl.Mbn = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(117925);
          return 0;
        case 11: 
          localdyl.MYc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(117925);
          return 0;
        case 12: 
          localdyl.AesKey = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(117925);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aah();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aah)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdyl.MlR = ((aah)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117925);
        return 0;
      }
      AppMethodBeat.o(117925);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyl
 * JD-Core Version:    0.7.0.1
 */