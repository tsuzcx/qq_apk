package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class wz
  extends dyy
{
  public String IkZ;
  public int SiA;
  public LinkedList<Integer> SiB;
  public int SiE;
  public String Siz;
  public String desc;
  public int fwx;
  public String tVo;
  
  public wz()
  {
    AppMethodBeat.i(72446);
    this.SiB = new LinkedList();
    AppMethodBeat.o(72446);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72447);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72447);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.fwx);
      if (this.tVo != null) {
        paramVarArgs.f(3, this.tVo);
      }
      if (this.IkZ != null) {
        paramVarArgs.f(4, this.IkZ);
      }
      if (this.Siz != null) {
        paramVarArgs.f(5, this.Siz);
      }
      paramVarArgs.aY(6, this.SiA);
      paramVarArgs.e(7, 2, this.SiB);
      if (this.desc != null) {
        paramVarArgs.f(8, this.desc);
      }
      paramVarArgs.aY(9, this.SiE);
      AppMethodBeat.o(72447);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label775;
      }
    }
    label775:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.fwx);
      paramInt = i;
      if (this.tVo != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tVo);
      }
      i = paramInt;
      if (this.IkZ != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.IkZ);
      }
      paramInt = i;
      if (this.Siz != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.Siz);
      }
      i = paramInt + g.a.a.b.b.a.bM(6, this.SiA) + g.a.a.a.c(7, 2, this.SiB);
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.desc);
      }
      i = g.a.a.b.b.a.bM(9, this.SiE);
      AppMethodBeat.o(72447);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SiB.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72447);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72447);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        wz localwz = (wz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72447);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jh localjh = new jh();
            if ((localObject != null) && (localObject.length > 0)) {
              localjh.parseFrom((byte[])localObject);
            }
            localwz.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(72447);
          return 0;
        case 2: 
          localwz.fwx = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(72447);
          return 0;
        case 3: 
          localwz.tVo = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72447);
          return 0;
        case 4: 
          localwz.IkZ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72447);
          return 0;
        case 5: 
          localwz.Siz = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72447);
          return 0;
        case 6: 
          localwz.SiA = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(72447);
          return 0;
        case 7: 
          localwz.SiB.add(Integer.valueOf(((g.a.a.a.a)localObject).abFh.AK()));
          AppMethodBeat.o(72447);
          return 0;
        case 8: 
          localwz.desc = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72447);
          return 0;
        }
        localwz.SiE = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(72447);
        return 0;
      }
      AppMethodBeat.o(72447);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wz
 * JD-Core Version:    0.7.0.1
 */