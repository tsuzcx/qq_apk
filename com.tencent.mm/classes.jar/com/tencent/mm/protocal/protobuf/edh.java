package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class edh
  extends dyy
{
  public String CRQ;
  public String CRR;
  public int CreateTime;
  public int HlE;
  public long HlH;
  public String RJQ;
  public String ScV;
  public int Sda;
  public String lVG;
  public int rWu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32427);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32427);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.lVG != null) {
        paramVarArgs.f(2, this.lVG);
      }
      if (this.CRR != null) {
        paramVarArgs.f(3, this.CRR);
      }
      if (this.CRQ != null) {
        paramVarArgs.f(4, this.CRQ);
      }
      paramVarArgs.aY(5, this.HlE);
      if (this.RJQ != null) {
        paramVarArgs.f(6, this.RJQ);
      }
      paramVarArgs.aY(7, this.CreateTime);
      paramVarArgs.aY(8, this.rWu);
      paramVarArgs.bm(9, this.HlH);
      if (this.ScV != null) {
        paramVarArgs.f(10, this.ScV);
      }
      paramVarArgs.aY(12, this.Sda);
      AppMethodBeat.o(32427);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label889;
      }
    }
    label889:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.lVG != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.lVG);
      }
      i = paramInt;
      if (this.CRR != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.CRR);
      }
      paramInt = i;
      if (this.CRQ != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.CRQ);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.HlE);
      paramInt = i;
      if (this.RJQ != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.RJQ);
      }
      i = paramInt + g.a.a.b.b.a.bM(7, this.CreateTime) + g.a.a.b.b.a.bM(8, this.rWu) + g.a.a.b.b.a.p(9, this.HlH);
      paramInt = i;
      if (this.ScV != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.ScV);
      }
      i = g.a.a.b.b.a.bM(12, this.Sda);
      AppMethodBeat.o(32427);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32427);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32427);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        edh localedh = (edh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 11: 
        default: 
          AppMethodBeat.o(32427);
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
            localedh.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(32427);
          return 0;
        case 2: 
          localedh.lVG = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32427);
          return 0;
        case 3: 
          localedh.CRR = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32427);
          return 0;
        case 4: 
          localedh.CRQ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32427);
          return 0;
        case 5: 
          localedh.HlE = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(32427);
          return 0;
        case 6: 
          localedh.RJQ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32427);
          return 0;
        case 7: 
          localedh.CreateTime = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(32427);
          return 0;
        case 8: 
          localedh.rWu = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(32427);
          return 0;
        case 9: 
          localedh.HlH = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(32427);
          return 0;
        case 10: 
          localedh.ScV = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32427);
          return 0;
        }
        localedh.Sda = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(32427);
        return 0;
      }
      AppMethodBeat.o(32427);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.edh
 * JD-Core Version:    0.7.0.1
 */