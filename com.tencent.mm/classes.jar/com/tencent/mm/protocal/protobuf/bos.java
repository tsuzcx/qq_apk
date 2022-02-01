package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bos
  extends dyl
{
  public int CPw;
  public int RIs;
  public int RKI;
  public int RLe;
  public String RMO;
  public eae RMd;
  public int RNa;
  public String SZE;
  public String SZF;
  public int SZH;
  public String SZI;
  public eaf SZZ;
  public int Sks;
  public int Skt;
  public eaf Taa;
  public eaf Tab;
  public eaf Tac;
  public String Tad;
  public int Tae;
  public eae Taf;
  public int Tag;
  public String Tah;
  public int Tai;
  public eae Taj;
  public String Tak;
  public String Tal;
  public String Tam;
  public bov Tan;
  public String UserName;
  public String sSU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152552);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.RLe);
      if (this.RMd != null)
      {
        paramVarArgs.oE(3, this.RMd.computeSize());
        this.RMd.writeFields(paramVarArgs);
      }
      if (this.SZZ != null)
      {
        paramVarArgs.oE(4, this.SZZ.computeSize());
        this.SZZ.writeFields(paramVarArgs);
      }
      if (this.Taa != null)
      {
        paramVarArgs.oE(5, this.Taa.computeSize());
        this.Taa.writeFields(paramVarArgs);
      }
      if (this.Tab != null)
      {
        paramVarArgs.oE(6, this.Tab.computeSize());
        this.Tab.writeFields(paramVarArgs);
      }
      if (this.Tac != null)
      {
        paramVarArgs.oE(7, this.Tac.computeSize());
        this.Tac.writeFields(paramVarArgs);
      }
      if (this.Tad != null) {
        paramVarArgs.f(8, this.Tad);
      }
      paramVarArgs.aY(9, this.Tae);
      paramVarArgs.aY(10, this.CPw);
      if (this.UserName != null) {
        paramVarArgs.f(11, this.UserName);
      }
      if (this.RMO != null) {
        paramVarArgs.f(12, this.RMO);
      }
      if (this.Taf != null)
      {
        paramVarArgs.oE(13, this.Taf.computeSize());
        this.Taf.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(14, this.RNa);
      paramVarArgs.aY(15, this.SZH);
      paramVarArgs.aY(16, this.RIs);
      if (this.sSU != null) {
        paramVarArgs.f(17, this.sSU);
      }
      paramVarArgs.aY(18, this.Sks);
      paramVarArgs.aY(19, this.Skt);
      paramVarArgs.aY(20, this.Tag);
      if (this.Tah != null) {
        paramVarArgs.f(21, this.Tah);
      }
      paramVarArgs.aY(22, this.Tai);
      if (this.Taj != null)
      {
        paramVarArgs.oE(23, this.Taj.computeSize());
        this.Taj.writeFields(paramVarArgs);
      }
      if (this.SZI != null) {
        paramVarArgs.f(24, this.SZI);
      }
      paramVarArgs.aY(25, this.RKI);
      if (this.SZE != null) {
        paramVarArgs.f(26, this.SZE);
      }
      if (this.SZF != null) {
        paramVarArgs.f(27, this.SZF);
      }
      if (this.Tak != null) {
        paramVarArgs.f(28, this.Tak);
      }
      if (this.Tal != null) {
        paramVarArgs.f(29, this.Tal);
      }
      if (this.Tam != null) {
        paramVarArgs.f(30, this.Tam);
      }
      if (this.Tan != null)
      {
        paramVarArgs.oE(31, this.Tan.computeSize());
        this.Tan.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152552);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label2532;
      }
    }
    label2532:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.RLe);
      paramInt = i;
      if (this.RMd != null) {
        paramInt = i + g.a.a.a.oD(3, this.RMd.computeSize());
      }
      i = paramInt;
      if (this.SZZ != null) {
        i = paramInt + g.a.a.a.oD(4, this.SZZ.computeSize());
      }
      paramInt = i;
      if (this.Taa != null) {
        paramInt = i + g.a.a.a.oD(5, this.Taa.computeSize());
      }
      i = paramInt;
      if (this.Tab != null) {
        i = paramInt + g.a.a.a.oD(6, this.Tab.computeSize());
      }
      paramInt = i;
      if (this.Tac != null) {
        paramInt = i + g.a.a.a.oD(7, this.Tac.computeSize());
      }
      i = paramInt;
      if (this.Tad != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.Tad);
      }
      i = i + g.a.a.b.b.a.bM(9, this.Tae) + g.a.a.b.b.a.bM(10, this.CPw);
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.UserName);
      }
      i = paramInt;
      if (this.RMO != null) {
        i = paramInt + g.a.a.b.b.a.g(12, this.RMO);
      }
      paramInt = i;
      if (this.Taf != null) {
        paramInt = i + g.a.a.a.oD(13, this.Taf.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(14, this.RNa) + g.a.a.b.b.a.bM(15, this.SZH) + g.a.a.b.b.a.bM(16, this.RIs);
      paramInt = i;
      if (this.sSU != null) {
        paramInt = i + g.a.a.b.b.a.g(17, this.sSU);
      }
      i = paramInt + g.a.a.b.b.a.bM(18, this.Sks) + g.a.a.b.b.a.bM(19, this.Skt) + g.a.a.b.b.a.bM(20, this.Tag);
      paramInt = i;
      if (this.Tah != null) {
        paramInt = i + g.a.a.b.b.a.g(21, this.Tah);
      }
      i = paramInt + g.a.a.b.b.a.bM(22, this.Tai);
      paramInt = i;
      if (this.Taj != null) {
        paramInt = i + g.a.a.a.oD(23, this.Taj.computeSize());
      }
      i = paramInt;
      if (this.SZI != null) {
        i = paramInt + g.a.a.b.b.a.g(24, this.SZI);
      }
      i += g.a.a.b.b.a.bM(25, this.RKI);
      paramInt = i;
      if (this.SZE != null) {
        paramInt = i + g.a.a.b.b.a.g(26, this.SZE);
      }
      i = paramInt;
      if (this.SZF != null) {
        i = paramInt + g.a.a.b.b.a.g(27, this.SZF);
      }
      paramInt = i;
      if (this.Tak != null) {
        paramInt = i + g.a.a.b.b.a.g(28, this.Tak);
      }
      i = paramInt;
      if (this.Tal != null) {
        i = paramInt + g.a.a.b.b.a.g(29, this.Tal);
      }
      paramInt = i;
      if (this.Tam != null) {
        paramInt = i + g.a.a.b.b.a.g(30, this.Tam);
      }
      i = paramInt;
      if (this.Tan != null) {
        i = paramInt + g.a.a.a.oD(31, this.Tan.computeSize());
      }
      AppMethodBeat.o(152552);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(152552);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bos localbos = (bos)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152552);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localbos.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152552);
          return 0;
        case 2: 
          localbos.RLe = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152552);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eae();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eae)localObject2).dd((byte[])localObject1);
            }
            localbos.RMd = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152552);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eaf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eaf)localObject2).de((byte[])localObject1);
            }
            localbos.SZZ = ((eaf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152552);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eaf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eaf)localObject2).de((byte[])localObject1);
            }
            localbos.Taa = ((eaf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152552);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eaf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eaf)localObject2).de((byte[])localObject1);
            }
            localbos.Tab = ((eaf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152552);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eaf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eaf)localObject2).de((byte[])localObject1);
            }
            localbos.Tac = ((eaf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152552);
          return 0;
        case 8: 
          localbos.Tad = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152552);
          return 0;
        case 9: 
          localbos.Tae = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152552);
          return 0;
        case 10: 
          localbos.CPw = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152552);
          return 0;
        case 11: 
          localbos.UserName = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152552);
          return 0;
        case 12: 
          localbos.RMO = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152552);
          return 0;
        case 13: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eae();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eae)localObject2).dd((byte[])localObject1);
            }
            localbos.Taf = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152552);
          return 0;
        case 14: 
          localbos.RNa = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152552);
          return 0;
        case 15: 
          localbos.SZH = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152552);
          return 0;
        case 16: 
          localbos.RIs = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152552);
          return 0;
        case 17: 
          localbos.sSU = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152552);
          return 0;
        case 18: 
          localbos.Sks = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152552);
          return 0;
        case 19: 
          localbos.Skt = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152552);
          return 0;
        case 20: 
          localbos.Tag = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152552);
          return 0;
        case 21: 
          localbos.Tah = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152552);
          return 0;
        case 22: 
          localbos.Tai = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152552);
          return 0;
        case 23: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eae();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eae)localObject2).dd((byte[])localObject1);
            }
            localbos.Taj = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152552);
          return 0;
        case 24: 
          localbos.SZI = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152552);
          return 0;
        case 25: 
          localbos.RKI = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152552);
          return 0;
        case 26: 
          localbos.SZE = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152552);
          return 0;
        case 27: 
          localbos.SZF = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152552);
          return 0;
        case 28: 
          localbos.Tak = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152552);
          return 0;
        case 29: 
          localbos.Tal = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152552);
          return 0;
        case 30: 
          localbos.Tam = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152552);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bov();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bov)localObject2).parseFrom((byte[])localObject1);
          }
          localbos.Tan = ((bov)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(152552);
        return 0;
      }
      AppMethodBeat.o(152552);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bos
 * JD-Core Version:    0.7.0.1
 */