package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fkw
  extends dyl
{
  public String UGj;
  public String UJl;
  public int UJm;
  public int UJn;
  public String UJo;
  public int UJp;
  public String UJq;
  public String UJr;
  public String appid;
  public String fHW;
  public String sNY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82489);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.fHW != null) {
        paramVarArgs.f(2, this.fHW);
      }
      if (this.UJl != null) {
        paramVarArgs.f(3, this.UJl);
      }
      paramVarArgs.aY(4, this.UJm);
      paramVarArgs.aY(5, this.UJn);
      if (this.UGj != null) {
        paramVarArgs.f(6, this.UGj);
      }
      if (this.sNY != null) {
        paramVarArgs.f(7, this.sNY);
      }
      if (this.appid != null) {
        paramVarArgs.f(8, this.appid);
      }
      if (this.UJo != null) {
        paramVarArgs.f(9, this.UJo);
      }
      paramVarArgs.aY(10, this.UJp);
      if (this.UJq != null) {
        paramVarArgs.f(11, this.UJq);
      }
      if (this.UJr != null) {
        paramVarArgs.f(12, this.UJr);
      }
      AppMethodBeat.o(82489);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label912;
      }
    }
    label912:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.fHW != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.fHW);
      }
      i = paramInt;
      if (this.UJl != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.UJl);
      }
      i = i + g.a.a.b.b.a.bM(4, this.UJm) + g.a.a.b.b.a.bM(5, this.UJn);
      paramInt = i;
      if (this.UGj != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.UGj);
      }
      i = paramInt;
      if (this.sNY != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.sNY);
      }
      paramInt = i;
      if (this.appid != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.appid);
      }
      i = paramInt;
      if (this.UJo != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.UJo);
      }
      i += g.a.a.b.b.a.bM(10, this.UJp);
      paramInt = i;
      if (this.UJq != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.UJq);
      }
      i = paramInt;
      if (this.UJr != null) {
        i = paramInt + g.a.a.b.b.a.g(12, this.UJr);
      }
      AppMethodBeat.o(82489);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(82489);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        fkw localfkw = (fkw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82489);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jg localjg = new jg();
            if ((localObject != null) && (localObject.length > 0)) {
              localjg.parseFrom((byte[])localObject);
            }
            localfkw.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(82489);
          return 0;
        case 2: 
          localfkw.fHW = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(82489);
          return 0;
        case 3: 
          localfkw.UJl = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(82489);
          return 0;
        case 4: 
          localfkw.UJm = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(82489);
          return 0;
        case 5: 
          localfkw.UJn = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(82489);
          return 0;
        case 6: 
          localfkw.UGj = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(82489);
          return 0;
        case 7: 
          localfkw.sNY = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(82489);
          return 0;
        case 8: 
          localfkw.appid = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(82489);
          return 0;
        case 9: 
          localfkw.UJo = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(82489);
          return 0;
        case 10: 
          localfkw.UJp = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(82489);
          return 0;
        case 11: 
          localfkw.UJq = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(82489);
          return 0;
        }
        localfkw.UJr = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(82489);
        return 0;
      }
      AppMethodBeat.o(82489);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fkw
 * JD-Core Version:    0.7.0.1
 */