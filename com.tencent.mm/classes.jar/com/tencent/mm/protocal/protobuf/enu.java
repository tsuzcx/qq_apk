package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class enu
  extends dop
{
  public int BsF;
  public int BsG;
  public int BsH;
  public SKBuiltinBuffer_t BsI;
  public String KEq;
  public String KEr;
  public String KEs;
  public dqi KHl;
  public dqi KHm;
  public String KHq;
  public int LYt;
  public String LbJ;
  public int LbK;
  public int LbL;
  public int LbM;
  public String LbN;
  public int Llx;
  public int LsF;
  public String MDZ;
  public int MVx;
  public String Md5;
  public String Mir;
  public int Mwb;
  public int NaY;
  public dqi NlB;
  public String NlC;
  public String NlD;
  public int NlE;
  public int NlF;
  public String NlG;
  public int NlH;
  public int NlI;
  public int NlJ;
  public String jfi;
  public String jfl;
  public int xKb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152719);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.NlB == null)
      {
        paramVarArgs = new b("Not all required fields were included: ClientImgId");
        AppMethodBeat.o(152719);
        throw paramVarArgs;
      }
      if (this.KHl == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(152719);
        throw paramVarArgs;
      }
      if (this.KHm == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(152719);
        throw paramVarArgs;
      }
      if (this.BsI == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(152719);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.NlB != null)
      {
        paramVarArgs.ni(2, this.NlB.computeSize());
        this.NlB.writeFields(paramVarArgs);
      }
      if (this.KHl != null)
      {
        paramVarArgs.ni(3, this.KHl.computeSize());
        this.KHl.writeFields(paramVarArgs);
      }
      if (this.KHm != null)
      {
        paramVarArgs.ni(4, this.KHm.computeSize());
        this.KHm.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(5, this.BsF);
      paramVarArgs.aM(6, this.BsG);
      paramVarArgs.aM(7, this.BsH);
      if (this.BsI != null)
      {
        paramVarArgs.ni(8, this.BsI.computeSize());
        this.BsI.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(9, this.xKb);
      if (this.KHq != null) {
        paramVarArgs.e(10, this.KHq);
      }
      paramVarArgs.aM(11, this.LYt);
      paramVarArgs.aM(12, this.Llx);
      paramVarArgs.aM(13, this.NaY);
      if (this.jfl != null) {
        paramVarArgs.e(14, this.jfl);
      }
      if (this.NlC != null) {
        paramVarArgs.e(15, this.NlC);
      }
      if (this.NlD != null) {
        paramVarArgs.e(16, this.NlD);
      }
      if (this.LbJ != null) {
        paramVarArgs.e(17, this.LbJ);
      }
      paramVarArgs.aM(18, this.LbK);
      paramVarArgs.aM(19, this.NlE);
      paramVarArgs.aM(20, this.NlF);
      if (this.NlG != null) {
        paramVarArgs.e(21, this.NlG);
      }
      paramVarArgs.aM(22, this.NlH);
      paramVarArgs.aM(23, this.NlI);
      paramVarArgs.aM(24, this.NlJ);
      if (this.Mir != null) {
        paramVarArgs.e(25, this.Mir);
      }
      paramVarArgs.aM(26, this.LsF);
      if (this.Md5 != null) {
        paramVarArgs.e(27, this.Md5);
      }
      paramVarArgs.aM(28, this.LbL);
      paramVarArgs.aM(29, this.LbM);
      paramVarArgs.aM(30, this.MVx);
      if (this.jfi != null) {
        paramVarArgs.e(31, this.jfi);
      }
      if (this.KEs != null) {
        paramVarArgs.e(32, this.KEs);
      }
      if (this.KEr != null) {
        paramVarArgs.e(33, this.KEr);
      }
      if (this.KEq != null) {
        paramVarArgs.e(34, this.KEq);
      }
      if (this.LbN != null) {
        paramVarArgs.e(35, this.LbN);
      }
      paramVarArgs.aM(36, this.Mwb);
      if (this.MDZ != null) {
        paramVarArgs.e(37, this.MDZ);
      }
      AppMethodBeat.o(152719);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label2794;
      }
    }
    label2794:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.NlB != null) {
        paramInt = i + g.a.a.a.nh(2, this.NlB.computeSize());
      }
      i = paramInt;
      if (this.KHl != null) {
        i = paramInt + g.a.a.a.nh(3, this.KHl.computeSize());
      }
      paramInt = i;
      if (this.KHm != null) {
        paramInt = i + g.a.a.a.nh(4, this.KHm.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.BsF) + g.a.a.b.b.a.bu(6, this.BsG) + g.a.a.b.b.a.bu(7, this.BsH);
      paramInt = i;
      if (this.BsI != null) {
        paramInt = i + g.a.a.a.nh(8, this.BsI.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(9, this.xKb);
      paramInt = i;
      if (this.KHq != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.KHq);
      }
      i = paramInt + g.a.a.b.b.a.bu(11, this.LYt) + g.a.a.b.b.a.bu(12, this.Llx) + g.a.a.b.b.a.bu(13, this.NaY);
      paramInt = i;
      if (this.jfl != null) {
        paramInt = i + g.a.a.b.b.a.f(14, this.jfl);
      }
      i = paramInt;
      if (this.NlC != null) {
        i = paramInt + g.a.a.b.b.a.f(15, this.NlC);
      }
      paramInt = i;
      if (this.NlD != null) {
        paramInt = i + g.a.a.b.b.a.f(16, this.NlD);
      }
      i = paramInt;
      if (this.LbJ != null) {
        i = paramInt + g.a.a.b.b.a.f(17, this.LbJ);
      }
      i = i + g.a.a.b.b.a.bu(18, this.LbK) + g.a.a.b.b.a.bu(19, this.NlE) + g.a.a.b.b.a.bu(20, this.NlF);
      paramInt = i;
      if (this.NlG != null) {
        paramInt = i + g.a.a.b.b.a.f(21, this.NlG);
      }
      i = paramInt + g.a.a.b.b.a.bu(22, this.NlH) + g.a.a.b.b.a.bu(23, this.NlI) + g.a.a.b.b.a.bu(24, this.NlJ);
      paramInt = i;
      if (this.Mir != null) {
        paramInt = i + g.a.a.b.b.a.f(25, this.Mir);
      }
      i = paramInt + g.a.a.b.b.a.bu(26, this.LsF);
      paramInt = i;
      if (this.Md5 != null) {
        paramInt = i + g.a.a.b.b.a.f(27, this.Md5);
      }
      i = paramInt + g.a.a.b.b.a.bu(28, this.LbL) + g.a.a.b.b.a.bu(29, this.LbM) + g.a.a.b.b.a.bu(30, this.MVx);
      paramInt = i;
      if (this.jfi != null) {
        paramInt = i + g.a.a.b.b.a.f(31, this.jfi);
      }
      i = paramInt;
      if (this.KEs != null) {
        i = paramInt + g.a.a.b.b.a.f(32, this.KEs);
      }
      paramInt = i;
      if (this.KEr != null) {
        paramInt = i + g.a.a.b.b.a.f(33, this.KEr);
      }
      i = paramInt;
      if (this.KEq != null) {
        i = paramInt + g.a.a.b.b.a.f(34, this.KEq);
      }
      paramInt = i;
      if (this.LbN != null) {
        paramInt = i + g.a.a.b.b.a.f(35, this.LbN);
      }
      i = paramInt + g.a.a.b.b.a.bu(36, this.Mwb);
      paramInt = i;
      if (this.MDZ != null) {
        paramInt = i + g.a.a.b.b.a.f(37, this.MDZ);
      }
      AppMethodBeat.o(152719);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.NlB == null)
        {
          paramVarArgs = new b("Not all required fields were included: ClientImgId");
          AppMethodBeat.o(152719);
          throw paramVarArgs;
        }
        if (this.KHl == null)
        {
          paramVarArgs = new b("Not all required fields were included: FromUserName");
          AppMethodBeat.o(152719);
          throw paramVarArgs;
        }
        if (this.KHm == null)
        {
          paramVarArgs = new b("Not all required fields were included: ToUserName");
          AppMethodBeat.o(152719);
          throw paramVarArgs;
        }
        if (this.BsI == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(152719);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152719);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        enu localenu = (enu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152719);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localenu.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152719);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localenu.NlB = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152719);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localenu.KHl = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152719);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localenu.KHm = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152719);
          return 0;
        case 5: 
          localenu.BsF = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152719);
          return 0;
        case 6: 
          localenu.BsG = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152719);
          return 0;
        case 7: 
          localenu.BsH = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152719);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localenu.BsI = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152719);
          return 0;
        case 9: 
          localenu.xKb = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152719);
          return 0;
        case 10: 
          localenu.KHq = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 11: 
          localenu.LYt = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152719);
          return 0;
        case 12: 
          localenu.Llx = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152719);
          return 0;
        case 13: 
          localenu.NaY = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152719);
          return 0;
        case 14: 
          localenu.jfl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 15: 
          localenu.NlC = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 16: 
          localenu.NlD = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 17: 
          localenu.LbJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 18: 
          localenu.LbK = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152719);
          return 0;
        case 19: 
          localenu.NlE = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152719);
          return 0;
        case 20: 
          localenu.NlF = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152719);
          return 0;
        case 21: 
          localenu.NlG = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 22: 
          localenu.NlH = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152719);
          return 0;
        case 23: 
          localenu.NlI = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152719);
          return 0;
        case 24: 
          localenu.NlJ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152719);
          return 0;
        case 25: 
          localenu.Mir = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 26: 
          localenu.LsF = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152719);
          return 0;
        case 27: 
          localenu.Md5 = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 28: 
          localenu.LbL = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152719);
          return 0;
        case 29: 
          localenu.LbM = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152719);
          return 0;
        case 30: 
          localenu.MVx = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152719);
          return 0;
        case 31: 
          localenu.jfi = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 32: 
          localenu.KEs = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 33: 
          localenu.KEr = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 34: 
          localenu.KEq = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 35: 
          localenu.LbN = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 36: 
          localenu.Mwb = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152719);
          return 0;
        }
        localenu.MDZ = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(152719);
        return 0;
      }
      AppMethodBeat.o(152719);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.enu
 * JD-Core Version:    0.7.0.1
 */