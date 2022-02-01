package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ek
  extends com.tencent.mm.bx.a
{
  public int CreateTime;
  public String CxC;
  public int CyE;
  public String CyF;
  public SKBuiltinBuffer_t CyG;
  public int CyH;
  public String CyI;
  public String CyJ;
  public String CyK;
  public int CyL;
  public String gKr;
  public String hnC;
  public int mBH;
  public int rNz;
  public String rZy;
  public String sdP;
  public String sdQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32116);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.sdQ != null) {
        paramVarArgs.d(1, this.sdQ);
      }
      if (this.hnC != null) {
        paramVarArgs.d(2, this.hnC);
      }
      paramVarArgs.aR(3, this.CyE);
      if (this.sdP != null) {
        paramVarArgs.d(4, this.sdP);
      }
      paramVarArgs.aR(5, this.mBH);
      if (this.gKr != null) {
        paramVarArgs.d(6, this.gKr);
      }
      paramVarArgs.aR(7, this.CreateTime);
      if (this.CyF != null) {
        paramVarArgs.d(8, this.CyF);
      }
      if (this.CyG != null)
      {
        paramVarArgs.kX(9, this.CyG.computeSize());
        this.CyG.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(10, this.rNz);
      paramVarArgs.aR(11, this.CyH);
      if (this.CxC != null) {
        paramVarArgs.d(12, this.CxC);
      }
      if (this.CyI != null) {
        paramVarArgs.d(13, this.CyI);
      }
      if (this.CyJ != null) {
        paramVarArgs.d(14, this.CyJ);
      }
      if (this.CyK != null) {
        paramVarArgs.d(15, this.CyK);
      }
      paramVarArgs.aR(16, this.CyL);
      if (this.rZy != null) {
        paramVarArgs.d(17, this.rZy);
      }
      AppMethodBeat.o(32116);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sdQ == null) {
        break label1221;
      }
    }
    label1221:
    for (paramInt = f.a.a.b.b.a.e(1, this.sdQ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.hnC != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.hnC);
      }
      i += f.a.a.b.b.a.bA(3, this.CyE);
      paramInt = i;
      if (this.sdP != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.sdP);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.mBH);
      paramInt = i;
      if (this.gKr != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.gKr);
      }
      i = paramInt + f.a.a.b.b.a.bA(7, this.CreateTime);
      paramInt = i;
      if (this.CyF != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.CyF);
      }
      i = paramInt;
      if (this.CyG != null) {
        i = paramInt + f.a.a.a.kW(9, this.CyG.computeSize());
      }
      i = i + f.a.a.b.b.a.bA(10, this.rNz) + f.a.a.b.b.a.bA(11, this.CyH);
      paramInt = i;
      if (this.CxC != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.CxC);
      }
      i = paramInt;
      if (this.CyI != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.CyI);
      }
      paramInt = i;
      if (this.CyJ != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.CyJ);
      }
      i = paramInt;
      if (this.CyK != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.CyK);
      }
      i += f.a.a.b.b.a.bA(16, this.CyL);
      paramInt = i;
      if (this.rZy != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.rZy);
      }
      AppMethodBeat.o(32116);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(32116);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ek localek = (ek)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32116);
          return -1;
        case 1: 
          localek.sdQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32116);
          return 0;
        case 2: 
          localek.hnC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32116);
          return 0;
        case 3: 
          localek.CyE = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32116);
          return 0;
        case 4: 
          localek.sdP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32116);
          return 0;
        case 5: 
          localek.mBH = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32116);
          return 0;
        case 6: 
          localek.gKr = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32116);
          return 0;
        case 7: 
          localek.CreateTime = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32116);
          return 0;
        case 8: 
          localek.CyF = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32116);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localek.CyG = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32116);
          return 0;
        case 10: 
          localek.rNz = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32116);
          return 0;
        case 11: 
          localek.CyH = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32116);
          return 0;
        case 12: 
          localek.CxC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32116);
          return 0;
        case 13: 
          localek.CyI = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32116);
          return 0;
        case 14: 
          localek.CyJ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32116);
          return 0;
        case 15: 
          localek.CyK = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32116);
          return 0;
        case 16: 
          localek.CyL = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32116);
          return 0;
        }
        localek.rZy = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(32116);
        return 0;
      }
      AppMethodBeat.o(32116);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ek
 * JD-Core Version:    0.7.0.1
 */