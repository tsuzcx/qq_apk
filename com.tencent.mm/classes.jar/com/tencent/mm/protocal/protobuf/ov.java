package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c;
import f.a.a.b;
import java.util.LinkedList;

public final class ov
  extends cld
{
  public c AgD;
  public long AgF;
  public long CMZ;
  public LinkedList<String> CNa;
  public int CNb;
  public int CNc;
  public String CNd;
  public String CNe;
  public String CNf;
  public boolean CNg;
  public int ntx;
  public String nty;
  
  public ov()
  {
    AppMethodBeat.i(91377);
    this.CNa = new LinkedList();
    AppMethodBeat.o(91377);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91378);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91378);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.ntx);
      if (this.nty != null) {
        paramVarArgs.d(3, this.nty);
      }
      paramVarArgs.aG(4, this.AgF);
      if (this.AgD != null)
      {
        paramVarArgs.kX(5, this.AgD.computeSize());
        this.AgD.writeFields(paramVarArgs);
      }
      paramVarArgs.aG(6, this.CMZ);
      paramVarArgs.e(7, 1, this.CNa);
      paramVarArgs.aR(8, this.CNb);
      paramVarArgs.aR(9, this.CNc);
      if (this.CNd != null) {
        paramVarArgs.d(10, this.CNd);
      }
      if (this.CNe != null) {
        paramVarArgs.d(11, this.CNe);
      }
      if (this.CNf != null) {
        paramVarArgs.d(12, this.CNf);
      }
      paramVarArgs.bg(13, this.CNg);
      AppMethodBeat.o(91378);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1082;
      }
    }
    label1082:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.ntx);
      paramInt = i;
      if (this.nty != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nty);
      }
      i = paramInt + f.a.a.b.b.a.q(4, this.AgF);
      paramInt = i;
      if (this.AgD != null) {
        paramInt = i + f.a.a.a.kW(5, this.AgD.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.q(6, this.CMZ) + f.a.a.a.c(7, 1, this.CNa) + f.a.a.b.b.a.bA(8, this.CNb) + f.a.a.b.b.a.bA(9, this.CNc);
      paramInt = i;
      if (this.CNd != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.CNd);
      }
      i = paramInt;
      if (this.CNe != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.CNe);
      }
      paramInt = i;
      if (this.CNf != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.CNf);
      }
      i = f.a.a.b.b.a.fY(13);
      AppMethodBeat.o(91378);
      return paramInt + (i + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CNa.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91378);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91378);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ov localov = (ov)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91378);
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
            localov.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91378);
          return 0;
        case 2: 
          localov.ntx = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91378);
          return 0;
        case 3: 
          localov.nty = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91378);
          return 0;
        case 4: 
          localov.AgF = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(91378);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new c();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((c)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localov.AgD = ((c)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91378);
          return 0;
        case 6: 
          localov.CMZ = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(91378);
          return 0;
        case 7: 
          localov.CNa.add(((f.a.a.a.a)localObject1).KhF.readString());
          AppMethodBeat.o(91378);
          return 0;
        case 8: 
          localov.CNb = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91378);
          return 0;
        case 9: 
          localov.CNc = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91378);
          return 0;
        case 10: 
          localov.CNd = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91378);
          return 0;
        case 11: 
          localov.CNe = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91378);
          return 0;
        case 12: 
          localov.CNf = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91378);
          return 0;
        }
        localov.CNg = ((f.a.a.a.a)localObject1).KhF.fHu();
        AppMethodBeat.o(91378);
        return 0;
      }
      AppMethodBeat.o(91378);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ov
 * JD-Core Version:    0.7.0.1
 */