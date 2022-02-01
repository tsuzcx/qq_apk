package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ecx
  extends dyy
{
  public LinkedList<fpj> RLp;
  public int TVM;
  public boolean Tic;
  public int Udm;
  public fpa Uhq;
  public int Uhr;
  public com.tencent.mm.cd.b Uhs;
  public String Uht;
  public String fwr;
  public int rVW;
  public int rVx;
  public int rWu;
  public int vht;
  
  public ecx()
  {
    AppMethodBeat.i(117922);
    this.RLp = new LinkedList();
    AppMethodBeat.o(117922);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117923);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(117923);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.rVW);
      paramVarArgs.aY(3, this.rWu);
      paramVarArgs.aY(4, this.TVM);
      paramVarArgs.aY(5, this.rVx);
      if (this.fwr != null) {
        paramVarArgs.f(6, this.fwr);
      }
      if (this.Uhq != null)
      {
        paramVarArgs.oE(7, this.Uhq.computeSize());
        this.Uhq.writeFields(paramVarArgs);
      }
      paramVarArgs.e(8, 8, this.RLp);
      paramVarArgs.aY(9, this.Udm);
      paramVarArgs.aY(10, this.Uhr);
      paramVarArgs.co(11, this.Tic);
      if (this.Uhs != null) {
        paramVarArgs.c(12, this.Uhs);
      }
      paramVarArgs.aY(13, this.vht);
      if (this.Uht != null) {
        paramVarArgs.f(14, this.Uht);
      }
      AppMethodBeat.o(117923);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1124;
      }
    }
    label1124:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.rVW) + g.a.a.b.b.a.bM(3, this.rWu) + g.a.a.b.b.a.bM(4, this.TVM) + g.a.a.b.b.a.bM(5, this.rVx);
      paramInt = i;
      if (this.fwr != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.fwr);
      }
      i = paramInt;
      if (this.Uhq != null) {
        i = paramInt + g.a.a.a.oD(7, this.Uhq.computeSize());
      }
      i = i + g.a.a.a.c(8, 8, this.RLp) + g.a.a.b.b.a.bM(9, this.Udm) + g.a.a.b.b.a.bM(10, this.Uhr) + (g.a.a.b.b.a.gL(11) + 1);
      paramInt = i;
      if (this.Uhs != null) {
        paramInt = i + g.a.a.b.b.a.b(12, this.Uhs);
      }
      i = paramInt + g.a.a.b.b.a.bM(13, this.vht);
      paramInt = i;
      if (this.Uht != null) {
        paramInt = i + g.a.a.b.b.a.g(14, this.Uht);
      }
      AppMethodBeat.o(117923);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.RLp.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(117923);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117923);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ecx localecx = (ecx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117923);
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
            localecx.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117923);
          return 0;
        case 2: 
          localecx.rVW = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(117923);
          return 0;
        case 3: 
          localecx.rWu = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(117923);
          return 0;
        case 4: 
          localecx.TVM = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(117923);
          return 0;
        case 5: 
          localecx.rVx = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(117923);
          return 0;
        case 6: 
          localecx.fwr = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(117923);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fpa();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fpa)localObject2).parseFrom((byte[])localObject1);
            }
            localecx.Uhq = ((fpa)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117923);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fpj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fpj)localObject2).parseFrom((byte[])localObject1);
            }
            localecx.RLp.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117923);
          return 0;
        case 9: 
          localecx.Udm = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(117923);
          return 0;
        case 10: 
          localecx.Uhr = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(117923);
          return 0;
        case 11: 
          localecx.Tic = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(117923);
          return 0;
        case 12: 
          localecx.Uhs = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(117923);
          return 0;
        case 13: 
          localecx.vht = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(117923);
          return 0;
        }
        localecx.Uht = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(117923);
        return 0;
      }
      AppMethodBeat.o(117923);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ecx
 * JD-Core Version:    0.7.0.1
 */