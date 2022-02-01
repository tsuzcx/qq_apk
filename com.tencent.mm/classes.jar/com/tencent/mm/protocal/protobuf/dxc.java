package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dxc
  extends dyl
{
  public String Ezw;
  public String TNB;
  public String UcK;
  public int fSe;
  public String ybP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116341);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ybP != null) {
        paramVarArgs.f(2, this.ybP);
      }
      if (this.TNB != null) {
        paramVarArgs.f(3, this.TNB);
      }
      paramVarArgs.aY(4, this.fSe);
      if (this.Ezw != null) {
        paramVarArgs.f(5, this.Ezw);
      }
      if (this.UcK != null) {
        paramVarArgs.f(6, this.UcK);
      }
      AppMethodBeat.o(116341);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label576;
      }
    }
    label576:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ybP != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.ybP);
      }
      i = paramInt;
      if (this.TNB != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.TNB);
      }
      i += g.a.a.b.b.a.bM(4, this.fSe);
      paramInt = i;
      if (this.Ezw != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.Ezw);
      }
      i = paramInt;
      if (this.UcK != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.UcK);
      }
      AppMethodBeat.o(116341);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(116341);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dxc localdxc = (dxc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(116341);
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
            localdxc.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(116341);
          return 0;
        case 2: 
          localdxc.ybP = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(116341);
          return 0;
        case 3: 
          localdxc.TNB = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(116341);
          return 0;
        case 4: 
          localdxc.fSe = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(116341);
          return 0;
        case 5: 
          localdxc.Ezw = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(116341);
          return 0;
        }
        localdxc.UcK = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(116341);
        return 0;
      }
      AppMethodBeat.o(116341);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxc
 * JD-Core Version:    0.7.0.1
 */