package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class aux
  extends cld
{
  public LinkedList<bfw> Dux;
  public int dcG;
  public String nTK;
  public String zRV;
  public boolean zRW;
  public String zRX;
  public String zRY;
  public String zRZ;
  public String zSa;
  public String zSb;
  public String zSc;
  public boolean zSe;
  
  public aux()
  {
    AppMethodBeat.i(72486);
    this.dcG = 0;
    this.nTK = "ok";
    this.Dux = new LinkedList();
    AppMethodBeat.o(72486);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72487);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72487);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.dcG);
      if (this.nTK != null) {
        paramVarArgs.d(3, this.nTK);
      }
      if (this.zRV != null) {
        paramVarArgs.d(4, this.zRV);
      }
      paramVarArgs.bg(6, this.zRW);
      if (this.zRX != null) {
        paramVarArgs.d(7, this.zRX);
      }
      if (this.zRY != null) {
        paramVarArgs.d(8, this.zRY);
      }
      if (this.zRZ != null) {
        paramVarArgs.d(9, this.zRZ);
      }
      if (this.zSa != null) {
        paramVarArgs.d(10, this.zSa);
      }
      if (this.zSb != null) {
        paramVarArgs.d(11, this.zSb);
      }
      if (this.zSc != null) {
        paramVarArgs.d(12, this.zSc);
      }
      paramVarArgs.e(13, 8, this.Dux);
      paramVarArgs.bg(14, this.zSe);
      AppMethodBeat.o(72487);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1130;
      }
    }
    label1130:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.dcG);
      paramInt = i;
      if (this.nTK != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nTK);
      }
      i = paramInt;
      if (this.zRV != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.zRV);
      }
      i += f.a.a.b.b.a.fY(6) + 1;
      paramInt = i;
      if (this.zRX != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.zRX);
      }
      i = paramInt;
      if (this.zRY != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.zRY);
      }
      paramInt = i;
      if (this.zRZ != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.zRZ);
      }
      i = paramInt;
      if (this.zSa != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.zSa);
      }
      paramInt = i;
      if (this.zSb != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.zSb);
      }
      i = paramInt;
      if (this.zSc != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.zSc);
      }
      paramInt = f.a.a.a.c(13, 8, this.Dux);
      int j = f.a.a.b.b.a.fY(14);
      AppMethodBeat.o(72487);
      return i + paramInt + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Dux.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72487);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72487);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aux localaux = (aux)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 5: 
        default: 
          AppMethodBeat.o(72487);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaux.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72487);
          return 0;
        case 2: 
          localaux.dcG = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72487);
          return 0;
        case 3: 
          localaux.nTK = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72487);
          return 0;
        case 4: 
          localaux.zRV = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72487);
          return 0;
        case 6: 
          localaux.zRW = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(72487);
          return 0;
        case 7: 
          localaux.zRX = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72487);
          return 0;
        case 8: 
          localaux.zRY = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72487);
          return 0;
        case 9: 
          localaux.zRZ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72487);
          return 0;
        case 10: 
          localaux.zSa = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72487);
          return 0;
        case 11: 
          localaux.zSb = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72487);
          return 0;
        case 12: 
          localaux.zSc = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72487);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bfw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bfw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaux.Dux.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72487);
          return 0;
        }
        localaux.zSe = ((f.a.a.a.a)localObject1).KhF.fHu();
        AppMethodBeat.o(72487);
        return 0;
      }
      AppMethodBeat.o(72487);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aux
 * JD-Core Version:    0.7.0.1
 */