package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class yi
  extends com.tencent.mm.bx.a
{
  public SKBuiltinBuffer_t CxB;
  public int DaA;
  public String Dal;
  public String Dam;
  public int Dan;
  public int Dao;
  public String Dap;
  public int Daq;
  public String Dar;
  public String Das;
  public int Dat;
  public int Dau;
  public LinkedList<clr> Dav;
  public String Daw;
  public int Dax;
  public int Day;
  public int Daz;
  public int ijM;
  public String ijR;
  public String mAQ;
  public String mBV;
  public String sed;
  
  public yi()
  {
    AppMethodBeat.i(32174);
    this.Dav = new LinkedList();
    AppMethodBeat.o(32174);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32175);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CxB == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(32175);
        throw paramVarArgs;
      }
      if (this.mAQ != null) {
        paramVarArgs.d(1, this.mAQ);
      }
      if (this.mBV != null) {
        paramVarArgs.d(2, this.mBV);
      }
      if (this.Dal != null) {
        paramVarArgs.d(3, this.Dal);
      }
      if (this.Dam != null) {
        paramVarArgs.d(4, this.Dam);
      }
      paramVarArgs.aR(5, this.ijM);
      if (this.CxB != null)
      {
        paramVarArgs.kX(6, this.CxB.computeSize());
        this.CxB.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(7, this.Dan);
      paramVarArgs.aR(8, this.Dao);
      if (this.Dap != null) {
        paramVarArgs.d(9, this.Dap);
      }
      paramVarArgs.aR(10, this.Daq);
      if (this.Dar != null) {
        paramVarArgs.d(11, this.Dar);
      }
      if (this.Das != null) {
        paramVarArgs.d(12, this.Das);
      }
      paramVarArgs.aR(13, this.Dat);
      paramVarArgs.aR(14, this.Dau);
      paramVarArgs.e(15, 8, this.Dav);
      if (this.Daw != null) {
        paramVarArgs.d(16, this.Daw);
      }
      paramVarArgs.aR(17, this.Dax);
      paramVarArgs.aR(18, this.Day);
      if (this.sed != null) {
        paramVarArgs.d(19, this.sed);
      }
      paramVarArgs.aR(20, this.Daz);
      paramVarArgs.aR(21, this.DaA);
      if (this.ijR != null) {
        paramVarArgs.d(22, this.ijR);
      }
      AppMethodBeat.o(32175);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mAQ == null) {
        break label1594;
      }
    }
    label1594:
    for (int i = f.a.a.b.b.a.e(1, this.mAQ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.mBV != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.mBV);
      }
      i = paramInt;
      if (this.Dal != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Dal);
      }
      paramInt = i;
      if (this.Dam != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Dam);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.ijM);
      paramInt = i;
      if (this.CxB != null) {
        paramInt = i + f.a.a.a.kW(6, this.CxB.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(7, this.Dan) + f.a.a.b.b.a.bA(8, this.Dao);
      paramInt = i;
      if (this.Dap != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Dap);
      }
      i = paramInt + f.a.a.b.b.a.bA(10, this.Daq);
      paramInt = i;
      if (this.Dar != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.Dar);
      }
      i = paramInt;
      if (this.Das != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.Das);
      }
      i = i + f.a.a.b.b.a.bA(13, this.Dat) + f.a.a.b.b.a.bA(14, this.Dau) + f.a.a.a.c(15, 8, this.Dav);
      paramInt = i;
      if (this.Daw != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.Daw);
      }
      i = paramInt + f.a.a.b.b.a.bA(17, this.Dax) + f.a.a.b.b.a.bA(18, this.Day);
      paramInt = i;
      if (this.sed != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.sed);
      }
      i = paramInt + f.a.a.b.b.a.bA(20, this.Daz) + f.a.a.b.b.a.bA(21, this.DaA);
      paramInt = i;
      if (this.ijR != null) {
        paramInt = i + f.a.a.b.b.a.e(22, this.ijR);
      }
      AppMethodBeat.o(32175);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Dav.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.CxB == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuf");
          AppMethodBeat.o(32175);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32175);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        yi localyi = (yi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32175);
          return -1;
        case 1: 
          localyi.mAQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32175);
          return 0;
        case 2: 
          localyi.mBV = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32175);
          return 0;
        case 3: 
          localyi.Dal = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32175);
          return 0;
        case 4: 
          localyi.Dam = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32175);
          return 0;
        case 5: 
          localyi.ijM = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32175);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localyi.CxB = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32175);
          return 0;
        case 7: 
          localyi.Dan = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32175);
          return 0;
        case 8: 
          localyi.Dao = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32175);
          return 0;
        case 9: 
          localyi.Dap = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32175);
          return 0;
        case 10: 
          localyi.Daq = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32175);
          return 0;
        case 11: 
          localyi.Dar = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32175);
          return 0;
        case 12: 
          localyi.Das = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32175);
          return 0;
        case 13: 
          localyi.Dat = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32175);
          return 0;
        case 14: 
          localyi.Dau = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32175);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new clr();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((clr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localyi.Dav.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32175);
          return 0;
        case 16: 
          localyi.Daw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32175);
          return 0;
        case 17: 
          localyi.Dax = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32175);
          return 0;
        case 18: 
          localyi.Day = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32175);
          return 0;
        case 19: 
          localyi.sed = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32175);
          return 0;
        case 20: 
          localyi.Daz = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32175);
          return 0;
        case 21: 
          localyi.DaA = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32175);
          return 0;
        }
        localyi.ijR = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(32175);
        return 0;
      }
      AppMethodBeat.o(32175);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yi
 * JD-Core Version:    0.7.0.1
 */