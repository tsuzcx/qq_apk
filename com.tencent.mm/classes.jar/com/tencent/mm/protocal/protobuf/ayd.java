package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ayd
  extends cqk
{
  public String Bkp;
  public boolean Bkq;
  public String Bkr;
  public String Bks;
  public String Bkt;
  public String Bku;
  public String Bkv;
  public String Bkw;
  public boolean Bky;
  public LinkedList<bjo> EPG;
  public int dae;
  public String oxf;
  
  public ayd()
  {
    AppMethodBeat.i(72486);
    this.dae = 0;
    this.oxf = "ok";
    this.EPG = new LinkedList();
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
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.dae);
      if (this.oxf != null) {
        paramVarArgs.d(3, this.oxf);
      }
      if (this.Bkp != null) {
        paramVarArgs.d(4, this.Bkp);
      }
      paramVarArgs.bl(6, this.Bkq);
      if (this.Bkr != null) {
        paramVarArgs.d(7, this.Bkr);
      }
      if (this.Bks != null) {
        paramVarArgs.d(8, this.Bks);
      }
      if (this.Bkt != null) {
        paramVarArgs.d(9, this.Bkt);
      }
      if (this.Bku != null) {
        paramVarArgs.d(10, this.Bku);
      }
      if (this.Bkv != null) {
        paramVarArgs.d(11, this.Bkv);
      }
      if (this.Bkw != null) {
        paramVarArgs.d(12, this.Bkw);
      }
      paramVarArgs.e(13, 8, this.EPG);
      paramVarArgs.bl(14, this.Bky);
      AppMethodBeat.o(72487);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1130;
      }
    }
    label1130:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.dae);
      paramInt = i;
      if (this.oxf != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oxf);
      }
      i = paramInt;
      if (this.Bkp != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Bkp);
      }
      i += f.a.a.b.b.a.fK(6) + 1;
      paramInt = i;
      if (this.Bkr != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Bkr);
      }
      i = paramInt;
      if (this.Bks != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.Bks);
      }
      paramInt = i;
      if (this.Bkt != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Bkt);
      }
      i = paramInt;
      if (this.Bku != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.Bku);
      }
      paramInt = i;
      if (this.Bkv != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.Bkv);
      }
      i = paramInt;
      if (this.Bkw != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.Bkw);
      }
      paramInt = f.a.a.a.c(13, 8, this.EPG);
      int j = f.a.a.b.b.a.fK(14);
      AppMethodBeat.o(72487);
      return i + paramInt + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EPG.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
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
        ayd localayd = (ayd)paramVarArgs[1];
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
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localayd.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72487);
          return 0;
        case 2: 
          localayd.dae = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72487);
          return 0;
        case 3: 
          localayd.oxf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72487);
          return 0;
        case 4: 
          localayd.Bkp = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72487);
          return 0;
        case 6: 
          localayd.Bkq = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(72487);
          return 0;
        case 7: 
          localayd.Bkr = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72487);
          return 0;
        case 8: 
          localayd.Bks = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72487);
          return 0;
        case 9: 
          localayd.Bkt = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72487);
          return 0;
        case 10: 
          localayd.Bku = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72487);
          return 0;
        case 11: 
          localayd.Bkv = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72487);
          return 0;
        case 12: 
          localayd.Bkw = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72487);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bjo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bjo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localayd.EPG.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72487);
          return 0;
        }
        localayd.Bky = ((f.a.a.a.a)localObject1).LVo.fZX();
        AppMethodBeat.o(72487);
        return 0;
      }
      AppMethodBeat.o(72487);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ayd
 * JD-Core Version:    0.7.0.1
 */