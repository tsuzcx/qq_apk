package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cgu
  extends dyy
{
  public String ROP;
  public String Sae;
  public fne SkF;
  public String TnX;
  public int TnY;
  public String TnZ;
  public LinkedList<dbx> Toa;
  public int Tob;
  public String Toc;
  public String Tod;
  public int Toe;
  public String Tof;
  public int Tog;
  public int Toh;
  public dbx Toi;
  public int rMN;
  public String wording;
  
  public cgu()
  {
    AppMethodBeat.i(123591);
    this.Toa = new LinkedList();
    AppMethodBeat.o(123591);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123592);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123592);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.SkF != null)
      {
        paramVarArgs.oE(2, this.SkF.computeSize());
        this.SkF.writeFields(paramVarArgs);
      }
      if (this.TnX != null) {
        paramVarArgs.f(3, this.TnX);
      }
      paramVarArgs.aY(4, this.TnY);
      paramVarArgs.aY(5, this.rMN);
      if (this.TnZ != null) {
        paramVarArgs.f(6, this.TnZ);
      }
      paramVarArgs.e(7, 8, this.Toa);
      paramVarArgs.aY(8, this.Tob);
      if (this.Toc != null) {
        paramVarArgs.f(9, this.Toc);
      }
      if (this.Tod != null) {
        paramVarArgs.f(10, this.Tod);
      }
      paramVarArgs.aY(11, this.Toe);
      if (this.wording != null) {
        paramVarArgs.f(12, this.wording);
      }
      if (this.ROP != null) {
        paramVarArgs.f(13, this.ROP);
      }
      if (this.Sae != null) {
        paramVarArgs.f(14, this.Sae);
      }
      if (this.Tof != null) {
        paramVarArgs.f(15, this.Tof);
      }
      paramVarArgs.aY(16, this.Tog);
      paramVarArgs.aY(17, this.Toh);
      if (this.Toi != null)
      {
        paramVarArgs.oE(18, this.Toi.computeSize());
        this.Toi.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(123592);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1482;
      }
    }
    label1482:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.SkF != null) {
        paramInt = i + g.a.a.a.oD(2, this.SkF.computeSize());
      }
      i = paramInt;
      if (this.TnX != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.TnX);
      }
      i = i + g.a.a.b.b.a.bM(4, this.TnY) + g.a.a.b.b.a.bM(5, this.rMN);
      paramInt = i;
      if (this.TnZ != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.TnZ);
      }
      i = paramInt + g.a.a.a.c(7, 8, this.Toa) + g.a.a.b.b.a.bM(8, this.Tob);
      paramInt = i;
      if (this.Toc != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.Toc);
      }
      i = paramInt;
      if (this.Tod != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.Tod);
      }
      i += g.a.a.b.b.a.bM(11, this.Toe);
      paramInt = i;
      if (this.wording != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.wording);
      }
      i = paramInt;
      if (this.ROP != null) {
        i = paramInt + g.a.a.b.b.a.g(13, this.ROP);
      }
      paramInt = i;
      if (this.Sae != null) {
        paramInt = i + g.a.a.b.b.a.g(14, this.Sae);
      }
      i = paramInt;
      if (this.Tof != null) {
        i = paramInt + g.a.a.b.b.a.g(15, this.Tof);
      }
      i = i + g.a.a.b.b.a.bM(16, this.Tog) + g.a.a.b.b.a.bM(17, this.Toh);
      paramInt = i;
      if (this.Toi != null) {
        paramInt = i + g.a.a.a.oD(18, this.Toi.computeSize());
      }
      AppMethodBeat.o(123592);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Toa.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(123592);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123592);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cgu localcgu = (cgu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123592);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localcgu.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123592);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fne();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fne)localObject2).parseFrom((byte[])localObject1);
            }
            localcgu.SkF = ((fne)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123592);
          return 0;
        case 3: 
          localcgu.TnX = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123592);
          return 0;
        case 4: 
          localcgu.TnY = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(123592);
          return 0;
        case 5: 
          localcgu.rMN = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(123592);
          return 0;
        case 6: 
          localcgu.TnZ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123592);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dbx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dbx)localObject2).parseFrom((byte[])localObject1);
            }
            localcgu.Toa.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123592);
          return 0;
        case 8: 
          localcgu.Tob = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(123592);
          return 0;
        case 9: 
          localcgu.Toc = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123592);
          return 0;
        case 10: 
          localcgu.Tod = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123592);
          return 0;
        case 11: 
          localcgu.Toe = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(123592);
          return 0;
        case 12: 
          localcgu.wording = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123592);
          return 0;
        case 13: 
          localcgu.ROP = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123592);
          return 0;
        case 14: 
          localcgu.Sae = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123592);
          return 0;
        case 15: 
          localcgu.Tof = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123592);
          return 0;
        case 16: 
          localcgu.Tog = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(123592);
          return 0;
        case 17: 
          localcgu.Toh = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(123592);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dbx();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dbx)localObject2).parseFrom((byte[])localObject1);
          }
          localcgu.Toi = ((dbx)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(123592);
        return 0;
      }
      AppMethodBeat.o(123592);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgu
 * JD-Core Version:    0.7.0.1
 */