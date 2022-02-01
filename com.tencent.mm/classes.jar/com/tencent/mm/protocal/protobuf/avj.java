package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class avj
  extends cvp
{
  public String FqD;
  public int FqN;
  public String GtG;
  public String GtH;
  public LinkedList<bos> GtM;
  public SKBuiltinBuffer_t Gub;
  public String Guc;
  public String Gud;
  public bqq Gue;
  public aut Guf;
  public String Gug;
  public int Guh;
  public LinkedList<oy> Gui;
  public String Guj;
  public acm Guk;
  public SKBuiltinBuffer_t Gul;
  public int Gum;
  public SKBuiltinBuffer_t Gun;
  public SKBuiltinBuffer_t Guo;
  public String SSID;
  public String Title;
  public String hDa;
  public String nDo;
  public String uOt;
  
  public avj()
  {
    AppMethodBeat.i(152553);
    this.Gui = new LinkedList();
    this.GtM = new LinkedList();
    AppMethodBeat.o(152553);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152554);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152554);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Guc != null) {
        paramVarArgs.d(2, this.Guc);
      }
      if (this.Gud != null) {
        paramVarArgs.d(3, this.Gud);
      }
      paramVarArgs.aS(4, this.FqN);
      if (this.Title != null) {
        paramVarArgs.d(5, this.Title);
      }
      if (this.hDa != null) {
        paramVarArgs.d(6, this.hDa);
      }
      if (this.Gue != null)
      {
        paramVarArgs.lC(7, this.Gue.computeSize());
        this.Gue.writeFields(paramVarArgs);
      }
      if (this.Guf != null)
      {
        paramVarArgs.lC(8, this.Guf.computeSize());
        this.Guf.writeFields(paramVarArgs);
      }
      if (this.nDo != null) {
        paramVarArgs.d(9, this.nDo);
      }
      if (this.Gug != null) {
        paramVarArgs.d(15, this.Gug);
      }
      paramVarArgs.aS(16, this.Guh);
      paramVarArgs.e(17, 8, this.Gui);
      if (this.Guj != null) {
        paramVarArgs.d(18, this.Guj);
      }
      if (this.SSID != null) {
        paramVarArgs.d(20, this.SSID);
      }
      if (this.FqD != null) {
        paramVarArgs.d(21, this.FqD);
      }
      if (this.Guk != null)
      {
        paramVarArgs.lC(22, this.Guk.computeSize());
        this.Guk.writeFields(paramVarArgs);
      }
      if (this.Gul != null)
      {
        paramVarArgs.lC(23, this.Gul.computeSize());
        this.Gul.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(24, this.Gum);
      paramVarArgs.e(25, 8, this.GtM);
      if (this.uOt != null) {
        paramVarArgs.d(26, this.uOt);
      }
      if (this.GtG != null) {
        paramVarArgs.d(27, this.GtG);
      }
      if (this.Gub != null)
      {
        paramVarArgs.lC(28, this.Gub.computeSize());
        this.Gub.writeFields(paramVarArgs);
      }
      if (this.GtH != null) {
        paramVarArgs.d(29, this.GtH);
      }
      if (this.Gun != null)
      {
        paramVarArgs.lC(30, this.Gun.computeSize());
        this.Gun.writeFields(paramVarArgs);
      }
      if (this.Guo != null)
      {
        paramVarArgs.lC(31, this.Guo.computeSize());
        this.Guo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152554);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2630;
      }
    }
    label2630:
    for (int i = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Guc != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Guc);
      }
      i = paramInt;
      if (this.Gud != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Gud);
      }
      i += f.a.a.b.b.a.bz(4, this.FqN);
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Title);
      }
      i = paramInt;
      if (this.hDa != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.hDa);
      }
      paramInt = i;
      if (this.Gue != null) {
        paramInt = i + f.a.a.a.lB(7, this.Gue.computeSize());
      }
      i = paramInt;
      if (this.Guf != null) {
        i = paramInt + f.a.a.a.lB(8, this.Guf.computeSize());
      }
      paramInt = i;
      if (this.nDo != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.nDo);
      }
      i = paramInt;
      if (this.Gug != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.Gug);
      }
      i = i + f.a.a.b.b.a.bz(16, this.Guh) + f.a.a.a.c(17, 8, this.Gui);
      paramInt = i;
      if (this.Guj != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.Guj);
      }
      i = paramInt;
      if (this.SSID != null) {
        i = paramInt + f.a.a.b.b.a.e(20, this.SSID);
      }
      paramInt = i;
      if (this.FqD != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.FqD);
      }
      i = paramInt;
      if (this.Guk != null) {
        i = paramInt + f.a.a.a.lB(22, this.Guk.computeSize());
      }
      paramInt = i;
      if (this.Gul != null) {
        paramInt = i + f.a.a.a.lB(23, this.Gul.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(24, this.Gum) + f.a.a.a.c(25, 8, this.GtM);
      paramInt = i;
      if (this.uOt != null) {
        paramInt = i + f.a.a.b.b.a.e(26, this.uOt);
      }
      i = paramInt;
      if (this.GtG != null) {
        i = paramInt + f.a.a.b.b.a.e(27, this.GtG);
      }
      paramInt = i;
      if (this.Gub != null) {
        paramInt = i + f.a.a.a.lB(28, this.Gub.computeSize());
      }
      i = paramInt;
      if (this.GtH != null) {
        i = paramInt + f.a.a.b.b.a.e(29, this.GtH);
      }
      paramInt = i;
      if (this.Gun != null) {
        paramInt = i + f.a.a.a.lB(30, this.Gun.computeSize());
      }
      i = paramInt;
      if (this.Guo != null) {
        i = paramInt + f.a.a.a.lB(31, this.Guo.computeSize());
      }
      AppMethodBeat.o(152554);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Gui.clear();
        this.GtM.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152554);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152554);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        avj localavj = (avj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        case 14: 
        case 19: 
        default: 
          AppMethodBeat.o(152554);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavj.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152554);
          return 0;
        case 2: 
          localavj.Guc = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 3: 
          localavj.Gud = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 4: 
          localavj.FqN = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152554);
          return 0;
        case 5: 
          localavj.Title = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 6: 
          localavj.hDa = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bqq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bqq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavj.Gue = ((bqq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152554);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aut();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aut)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavj.Guf = ((aut)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152554);
          return 0;
        case 9: 
          localavj.nDo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 15: 
          localavj.Gug = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 16: 
          localavj.Guh = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152554);
          return 0;
        case 17: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new oy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((oy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavj.Gui.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152554);
          return 0;
        case 18: 
          localavj.Guj = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 20: 
          localavj.SSID = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 21: 
          localavj.FqD = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 22: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new acm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((acm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavj.Guk = ((acm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152554);
          return 0;
        case 23: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavj.Gul = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152554);
          return 0;
        case 24: 
          localavj.Gum = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152554);
          return 0;
        case 25: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bos();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bos)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavj.GtM.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152554);
          return 0;
        case 26: 
          localavj.uOt = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 27: 
          localavj.GtG = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 28: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavj.Gub = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152554);
          return 0;
        case 29: 
          localavj.GtH = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 30: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavj.Gun = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152554);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localavj.Guo = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152554);
        return 0;
      }
      AppMethodBeat.o(152554);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avj
 * JD-Core Version:    0.7.0.1
 */