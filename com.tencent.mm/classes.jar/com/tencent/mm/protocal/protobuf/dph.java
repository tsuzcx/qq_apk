package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dph
  extends cvp
{
  public String FFn;
  public ctf HDh;
  public String HDi;
  public String HDj;
  public String HDk;
  public ctf HDs;
  public LinkedList<adu> HDt;
  public String HDu;
  public String HDv;
  public String HDw;
  public String oyb;
  public int ozR;
  public String ozS;
  public String xVb;
  public String xVc;
  public int xVd;
  public int xZf;
  
  public dph()
  {
    AppMethodBeat.i(72598);
    this.HDt = new LinkedList();
    AppMethodBeat.o(72598);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72599);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.ozR);
      if (this.ozS != null) {
        paramVarArgs.d(3, this.ozS);
      }
      paramVarArgs.aS(4, this.xVd);
      if (this.HDs != null)
      {
        paramVarArgs.lC(5, this.HDs.computeSize());
        this.HDs.writeFields(paramVarArgs);
      }
      if (this.HDi != null) {
        paramVarArgs.d(6, this.HDi);
      }
      if (this.HDj != null) {
        paramVarArgs.d(7, this.HDj);
      }
      if (this.xVb != null) {
        paramVarArgs.d(8, this.xVb);
      }
      if (this.xVc != null) {
        paramVarArgs.d(9, this.xVc);
      }
      if (this.oyb != null) {
        paramVarArgs.d(10, this.oyb);
      }
      if (this.FFn != null) {
        paramVarArgs.d(11, this.FFn);
      }
      paramVarArgs.aS(12, this.xZf);
      paramVarArgs.e(13, 8, this.HDt);
      if (this.HDu != null) {
        paramVarArgs.d(14, this.HDu);
      }
      if (this.HDv != null) {
        paramVarArgs.d(15, this.HDv);
      }
      if (this.HDk != null) {
        paramVarArgs.d(16, this.HDk);
      }
      if (this.HDw != null) {
        paramVarArgs.d(17, this.HDw);
      }
      if (this.HDh != null)
      {
        paramVarArgs.lC(18, this.HDh.computeSize());
        this.HDh.writeFields(paramVarArgs);
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
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.ozR);
      paramInt = i;
      if (this.ozS != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ozS);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.xVd);
      paramInt = i;
      if (this.HDs != null) {
        paramInt = i + f.a.a.a.lB(5, this.HDs.computeSize());
      }
      i = paramInt;
      if (this.HDi != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.HDi);
      }
      paramInt = i;
      if (this.HDj != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.HDj);
      }
      i = paramInt;
      if (this.xVb != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.xVb);
      }
      paramInt = i;
      if (this.xVc != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.xVc);
      }
      i = paramInt;
      if (this.oyb != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.oyb);
      }
      paramInt = i;
      if (this.FFn != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.FFn);
      }
      i = paramInt + f.a.a.b.b.a.bz(12, this.xZf) + f.a.a.a.c(13, 8, this.HDt);
      paramInt = i;
      if (this.HDu != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.HDu);
      }
      i = paramInt;
      if (this.HDv != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.HDv);
      }
      paramInt = i;
      if (this.HDk != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.HDk);
      }
      i = paramInt;
      if (this.HDw != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.HDw);
      }
      paramInt = i;
      if (this.HDh != null) {
        paramInt = i + f.a.a.a.lB(18, this.HDh.computeSize());
      }
      AppMethodBeat.o(72599);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HDt.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(72599);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dph localdph = (dph)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72599);
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
            localdph.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72599);
          return 0;
        case 2: 
          localdph.ozR = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72599);
          return 0;
        case 3: 
          localdph.ozS = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 4: 
          localdph.xVd = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72599);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ctf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ctf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdph.HDs = ((ctf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72599);
          return 0;
        case 6: 
          localdph.HDi = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 7: 
          localdph.HDj = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 8: 
          localdph.xVb = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 9: 
          localdph.xVc = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 10: 
          localdph.oyb = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 11: 
          localdph.FFn = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 12: 
          localdph.xZf = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72599);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new adu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((adu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdph.HDt.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72599);
          return 0;
        case 14: 
          localdph.HDu = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 15: 
          localdph.HDv = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 16: 
          localdph.HDk = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 17: 
          localdph.HDw = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72599);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ctf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ctf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdph.HDh = ((ctf)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dph
 * JD-Core Version:    0.7.0.1
 */