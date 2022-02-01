package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cwj
  extends cld
{
  public LinkedList<SnsObject> CEH;
  public cwh DJb;
  public int DOR;
  public int EmO;
  public LinkedList<cwl> EmP;
  public String Emn;
  public int Emr;
  public cvr Emt;
  public int EnI;
  public int Eof;
  public long Eog;
  public long Eoh;
  public String Eoi;
  public boolean Eoj;
  
  public cwj()
  {
    AppMethodBeat.i(125836);
    this.CEH = new LinkedList();
    this.EmP = new LinkedList();
    AppMethodBeat.o(125836);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125837);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(125837);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Emn != null) {
        paramVarArgs.d(2, this.Emn);
      }
      paramVarArgs.aR(3, this.DOR);
      paramVarArgs.e(4, 8, this.CEH);
      paramVarArgs.aR(5, this.Eof);
      if (this.DJb != null)
      {
        paramVarArgs.kX(6, this.DJb.computeSize());
        this.DJb.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(7, this.EnI);
      paramVarArgs.aR(8, this.Emr);
      if (this.Emt != null)
      {
        paramVarArgs.kX(9, this.Emt.computeSize());
        this.Emt.writeFields(paramVarArgs);
      }
      paramVarArgs.aG(10, this.Eog);
      paramVarArgs.aG(11, this.Eoh);
      if (this.Eoi != null) {
        paramVarArgs.d(12, this.Eoi);
      }
      paramVarArgs.aR(13, this.EmO);
      paramVarArgs.e(14, 8, this.EmP);
      paramVarArgs.bg(15, this.Eoj);
      AppMethodBeat.o(125837);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1434;
      }
    }
    label1434:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Emn != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Emn);
      }
      i = i + f.a.a.b.b.a.bA(3, this.DOR) + f.a.a.a.c(4, 8, this.CEH) + f.a.a.b.b.a.bA(5, this.Eof);
      paramInt = i;
      if (this.DJb != null) {
        paramInt = i + f.a.a.a.kW(6, this.DJb.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(7, this.EnI) + f.a.a.b.b.a.bA(8, this.Emr);
      paramInt = i;
      if (this.Emt != null) {
        paramInt = i + f.a.a.a.kW(9, this.Emt.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.q(10, this.Eog) + f.a.a.b.b.a.q(11, this.Eoh);
      paramInt = i;
      if (this.Eoi != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.Eoi);
      }
      i = f.a.a.b.b.a.bA(13, this.EmO);
      int j = f.a.a.a.c(14, 8, this.EmP);
      int k = f.a.a.b.b.a.fY(15);
      AppMethodBeat.o(125837);
      return paramInt + i + j + (k + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CEH.clear();
        this.EmP.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(125837);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125837);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cwj localcwj = (cwj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125837);
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
            localcwj.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125837);
          return 0;
        case 2: 
          localcwj.Emn = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125837);
          return 0;
        case 3: 
          localcwj.DOR = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125837);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SnsObject();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SnsObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcwj.CEH.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125837);
          return 0;
        case 5: 
          localcwj.Eof = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125837);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcwj.DJb = ((cwh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125837);
          return 0;
        case 7: 
          localcwj.EnI = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125837);
          return 0;
        case 8: 
          localcwj.Emr = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125837);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cvr();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cvr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcwj.Emt = ((cvr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125837);
          return 0;
        case 10: 
          localcwj.Eog = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(125837);
          return 0;
        case 11: 
          localcwj.Eoh = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(125837);
          return 0;
        case 12: 
          localcwj.Eoi = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125837);
          return 0;
        case 13: 
          localcwj.EmO = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125837);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcwj.EmP.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125837);
          return 0;
        }
        localcwj.Eoj = ((f.a.a.a.a)localObject1).KhF.fHu();
        AppMethodBeat.o(125837);
        return 0;
      }
      AppMethodBeat.o(125837);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwj
 * JD-Core Version:    0.7.0.1
 */