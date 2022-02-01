package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class byl
  extends cqk
{
  public String DRX;
  public LinkedList<byp> FnC;
  public String FnD;
  public boolean FnE;
  public boolean FnF;
  public boolean FnG;
  public LinkedList<bym> FnH;
  public boolean FnI;
  public String hiX;
  public boolean kfb;
  public int kfc;
  public int kfd;
  public String kfe;
  public String kff;
  
  public byl()
  {
    AppMethodBeat.i(82461);
    this.FnC = new LinkedList();
    this.FnH = new LinkedList();
    AppMethodBeat.o(82461);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82462);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(82462);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.FnC);
      if (this.hiX != null) {
        paramVarArgs.d(4, this.hiX);
      }
      if (this.FnD != null) {
        paramVarArgs.d(5, this.FnD);
      }
      if (this.DRX != null) {
        paramVarArgs.d(6, this.DRX);
      }
      paramVarArgs.bl(8, this.FnE);
      paramVarArgs.bl(9, this.FnF);
      paramVarArgs.bl(10, this.FnG);
      paramVarArgs.e(11, 8, this.FnH);
      paramVarArgs.bl(12, this.FnI);
      paramVarArgs.bl(13, this.kfb);
      paramVarArgs.aR(14, this.kfc);
      paramVarArgs.aR(15, this.kfd);
      if (this.kfe != null) {
        paramVarArgs.d(16, this.kfe);
      }
      if (this.kff != null) {
        paramVarArgs.d(17, this.kff);
      }
      AppMethodBeat.o(82462);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1254;
      }
    }
    label1254:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(3, 8, this.FnC);
      paramInt = i;
      if (this.hiX != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.hiX);
      }
      i = paramInt;
      if (this.FnD != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FnD);
      }
      paramInt = i;
      if (this.DRX != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DRX);
      }
      i = paramInt + (f.a.a.b.b.a.fK(8) + 1) + (f.a.a.b.b.a.fK(9) + 1) + (f.a.a.b.b.a.fK(10) + 1) + f.a.a.a.c(11, 8, this.FnH) + (f.a.a.b.b.a.fK(12) + 1) + (f.a.a.b.b.a.fK(13) + 1) + f.a.a.b.b.a.bx(14, this.kfc) + f.a.a.b.b.a.bx(15, this.kfd);
      paramInt = i;
      if (this.kfe != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.kfe);
      }
      i = paramInt;
      if (this.kff != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.kff);
      }
      AppMethodBeat.o(82462);
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
          AppMethodBeat.o(82462);
          throw paramVarArgs;
        }
        AppMethodBeat.o(82462);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        byl localbyl = (byl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 2: 
        case 7: 
        default: 
          AppMethodBeat.o(82462);
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
            localbyl.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82462);
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
            localbyl.FnC.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82462);
          return 0;
        case 4: 
          localbyl.hiX = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(82462);
          return 0;
        case 5: 
          localbyl.FnD = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(82462);
          return 0;
        case 6: 
          localbyl.DRX = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(82462);
          return 0;
        case 8: 
          localbyl.FnE = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(82462);
          return 0;
        case 9: 
          localbyl.FnF = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(82462);
          return 0;
        case 10: 
          localbyl.FnG = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(82462);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bym();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bym)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbyl.FnH.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82462);
          return 0;
        case 12: 
          localbyl.FnI = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(82462);
          return 0;
        case 13: 
          localbyl.kfb = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(82462);
          return 0;
        case 14: 
          localbyl.kfc = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(82462);
          return 0;
        case 15: 
          localbyl.kfd = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(82462);
          return 0;
        case 16: 
          localbyl.kfe = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(82462);
          return 0;
        }
        localbyl.kff = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(82462);
        return 0;
      }
      AppMethodBeat.o(82462);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byl
 * JD-Core Version:    0.7.0.1
 */