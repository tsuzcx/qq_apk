package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cja
  extends cqk
{
  public LinkedList<byp> FnC;
  public String FnD;
  public LinkedList<bym> FnH;
  public boolean FwU;
  public String djj;
  public String hiX;
  public boolean kfb;
  public int kfc;
  public int kfd;
  public String kfe;
  public String kff;
  
  public cja()
  {
    AppMethodBeat.i(82468);
    this.FnC = new LinkedList();
    this.FnH = new LinkedList();
    AppMethodBeat.o(82468);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82469);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(82469);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bl(2, this.FwU);
      paramVarArgs.e(3, 8, this.FnC);
      if (this.djj != null) {
        paramVarArgs.d(4, this.djj);
      }
      if (this.hiX != null) {
        paramVarArgs.d(5, this.hiX);
      }
      if (this.FnD != null) {
        paramVarArgs.d(6, this.FnD);
      }
      paramVarArgs.e(7, 8, this.FnH);
      paramVarArgs.bl(8, this.kfb);
      paramVarArgs.aR(9, this.kfc);
      paramVarArgs.aR(10, this.kfd);
      if (this.kfe != null) {
        paramVarArgs.d(11, this.kfe);
      }
      if (this.kff != null) {
        paramVarArgs.d(12, this.kff);
      }
      AppMethodBeat.o(82469);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1118;
      }
    }
    label1118:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (f.a.a.b.b.a.fK(2) + 1) + f.a.a.a.c(3, 8, this.FnC);
      paramInt = i;
      if (this.djj != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.djj);
      }
      i = paramInt;
      if (this.hiX != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.hiX);
      }
      paramInt = i;
      if (this.FnD != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FnD);
      }
      i = paramInt + f.a.a.a.c(7, 8, this.FnH) + (f.a.a.b.b.a.fK(8) + 1) + f.a.a.b.b.a.bx(9, this.kfc) + f.a.a.b.b.a.bx(10, this.kfd);
      paramInt = i;
      if (this.kfe != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.kfe);
      }
      i = paramInt;
      if (this.kff != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.kff);
      }
      AppMethodBeat.o(82469);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FnC.clear();
        this.FnH.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(82469);
          throw paramVarArgs;
        }
        AppMethodBeat.o(82469);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cja localcja = (cja)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82469);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcja.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82469);
          return 0;
        case 2: 
          localcja.FwU = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(82469);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new byp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((byp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcja.FnC.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82469);
          return 0;
        case 4: 
          localcja.djj = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(82469);
          return 0;
        case 5: 
          localcja.hiX = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(82469);
          return 0;
        case 6: 
          localcja.FnD = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(82469);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bym();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bym)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcja.FnH.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82469);
          return 0;
        case 8: 
          localcja.kfb = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(82469);
          return 0;
        case 9: 
          localcja.kfc = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(82469);
          return 0;
        case 10: 
          localcja.kfd = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(82469);
          return 0;
        case 11: 
          localcja.kfe = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(82469);
          return 0;
        }
        localcja.kff = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(82469);
        return 0;
      }
      AppMethodBeat.o(82469);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cja
 * JD-Core Version:    0.7.0.1
 */