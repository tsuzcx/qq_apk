package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eka
  extends dpc
{
  public String ClU;
  public String ClV;
  public int ClW;
  public int CpN;
  public String KRv;
  public dmp Nja;
  public String Njb;
  public String Njc;
  public String Njd;
  public dmp Njl;
  public LinkedList<agg> Njm;
  public String Njn;
  public String Njo;
  public String Njp;
  public String pSm;
  public int pTZ;
  public String pUa;
  
  public eka()
  {
    AppMethodBeat.i(72598);
    this.Njm = new LinkedList();
    AppMethodBeat.o(72598);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72599);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.pTZ);
      if (this.pUa != null) {
        paramVarArgs.e(3, this.pUa);
      }
      paramVarArgs.aM(4, this.ClW);
      if (this.Njl != null)
      {
        paramVarArgs.ni(5, this.Njl.computeSize());
        this.Njl.writeFields(paramVarArgs);
      }
      if (this.Njb != null) {
        paramVarArgs.e(6, this.Njb);
      }
      if (this.Njc != null) {
        paramVarArgs.e(7, this.Njc);
      }
      if (this.ClU != null) {
        paramVarArgs.e(8, this.ClU);
      }
      if (this.ClV != null) {
        paramVarArgs.e(9, this.ClV);
      }
      if (this.pSm != null) {
        paramVarArgs.e(10, this.pSm);
      }
      if (this.KRv != null) {
        paramVarArgs.e(11, this.KRv);
      }
      paramVarArgs.aM(12, this.CpN);
      paramVarArgs.e(13, 8, this.Njm);
      if (this.Njn != null) {
        paramVarArgs.e(14, this.Njn);
      }
      if (this.Njo != null) {
        paramVarArgs.e(15, this.Njo);
      }
      if (this.Njd != null) {
        paramVarArgs.e(16, this.Njd);
      }
      if (this.Njp != null) {
        paramVarArgs.e(17, this.Njp);
      }
      if (this.Nja != null)
      {
        paramVarArgs.ni(18, this.Nja.computeSize());
        this.Nja.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72599);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1574;
      }
    }
    label1574:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.pTZ);
      paramInt = i;
      if (this.pUa != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.pUa);
      }
      i = paramInt + g.a.a.b.b.a.bu(4, this.ClW);
      paramInt = i;
      if (this.Njl != null) {
        paramInt = i + g.a.a.a.nh(5, this.Njl.computeSize());
      }
      i = paramInt;
      if (this.Njb != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.Njb);
      }
      paramInt = i;
      if (this.Njc != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.Njc);
      }
      i = paramInt;
      if (this.ClU != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.ClU);
      }
      paramInt = i;
      if (this.ClV != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.ClV);
      }
      i = paramInt;
      if (this.pSm != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.pSm);
      }
      paramInt = i;
      if (this.KRv != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.KRv);
      }
      i = paramInt + g.a.a.b.b.a.bu(12, this.CpN) + g.a.a.a.c(13, 8, this.Njm);
      paramInt = i;
      if (this.Njn != null) {
        paramInt = i + g.a.a.b.b.a.f(14, this.Njn);
      }
      i = paramInt;
      if (this.Njo != null) {
        i = paramInt + g.a.a.b.b.a.f(15, this.Njo);
      }
      paramInt = i;
      if (this.Njd != null) {
        paramInt = i + g.a.a.b.b.a.f(16, this.Njd);
      }
      i = paramInt;
      if (this.Njp != null) {
        i = paramInt + g.a.a.b.b.a.f(17, this.Njp);
      }
      paramInt = i;
      if (this.Nja != null) {
        paramInt = i + g.a.a.a.nh(18, this.Nja.computeSize());
      }
      AppMethodBeat.o(72599);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Njm.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(72599);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eka localeka = (eka)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72599);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeka.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72599);
          return 0;
        case 2: 
          localeka.pTZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72599);
          return 0;
        case 3: 
          localeka.pUa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 4: 
          localeka.ClW = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72599);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dmp();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dmp)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeka.Njl = ((dmp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72599);
          return 0;
        case 6: 
          localeka.Njb = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 7: 
          localeka.Njc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 8: 
          localeka.ClU = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 9: 
          localeka.ClV = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 10: 
          localeka.pSm = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 11: 
          localeka.KRv = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 12: 
          localeka.CpN = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72599);
          return 0;
        case 13: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new agg();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((agg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeka.Njm.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72599);
          return 0;
        case 14: 
          localeka.Njn = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 15: 
          localeka.Njo = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 16: 
          localeka.Njd = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 17: 
          localeka.Njp = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72599);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dmp();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dmp)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localeka.Nja = ((dmp)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72599);
        return 0;
      }
      AppMethodBeat.o(72599);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eka
 * JD-Core Version:    0.7.0.1
 */